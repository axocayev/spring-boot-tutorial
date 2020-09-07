package atl.academy.i18ndemo.controller;

import atl.academy.i18ndemo.model.Product;
import atl.academy.i18ndemo.model.ProductDetail;
import atl.academy.i18ndemo.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PageController {
    ProductRepository productRepository;
    LocaleResolver localeResolver;

    public PageController(ProductRepository productRepository, LocaleResolver localeResolver) {
        this.productRepository = productRepository;
        this.localeResolver = localeResolver;
    }

    @GetMapping({"/", "/home", "/index"})
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/products")
    public String products(Model model) {
        List<Product> products = productRepository.findAll();
        products.stream().forEach(System.out::println);
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/products/detail")
    public String products(Model model, @RequestParam("id") Long id, HttpServletRequest httpRequest) {

        Product product = productRepository.getOne(id);

        List<ProductDetail> productDetails = product.getProductDetailList();

        String displayLanguage = localeResolver.resolveLocale(httpRequest).getDisplayLanguage();
         String lang=null;
        if (displayLanguage.equals("English")) {
            lang = "en";
        } else if (displayLanguage.equals("Russian")) {
            lang = "ru";
        } else if (displayLanguage.equals("Azerbaijani")) {
            lang = "az";
        }
        ProductDetail productDetail=null;
        for(ProductDetail p:productDetails){
            if(p.getLang().equals(lang)){
                productDetail=p;
            }
        }
       // model.addAttribute("productdetail", productDetails.stream().filter(x -> x.getLang().equals(lang)).collect(Collectors.toList()).get(0));
        model.addAttribute("productdetail",productDetail);
        model.addAttribute("product", product);
        return "product-detail";
    }

}
