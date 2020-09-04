package az.atlacademy.valdiations.contorller;

import az.atlacademy.valdiations.model.Product;
import az.atlacademy.valdiations.repository.ProductRepository;
import az.atlacademy.valdiations.validator.ProductValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ProductController {
    private ProductRepository productRepository;
    private ProductValidator productValidator;

    public ProductController(ProductRepository productRepository, ProductValidator productValidator) {
        this.productRepository = productRepository;
        this.productValidator = productValidator;
    }

    @GetMapping("/products/add")
    public String getForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/products/save")
    public String saveProduct(Model model, @ModelAttribute Product product, BindingResult bindingResult) {
        log.info("product {} ",product);
        productValidator.validate(product,bindingResult);
        if(bindingResult.hasErrors()){
            return "product-form";
        }
        log.info("new product object {}", product);

        return "product-list";
    }
}
