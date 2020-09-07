package atl.academy.i18ndemo.configuration;

import atl.academy.i18ndemo.model.Product;
import atl.academy.i18ndemo.model.ProductDetail;
import atl.academy.i18ndemo.repository.ProductDetailRepository;
import atl.academy.i18ndemo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class ProductConfig implements CommandLineRunner {

    ProductDetailRepository productDetailRepository;
    ProductRepository productRepository;

    public ProductConfig(ProductDetailRepository productDetailRepository, ProductRepository productRepository) {
        this.productDetailRepository = productDetailRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       /* Product product=new Product();
        productRepository.save(product);
log.info("product {} ",product);
        ProductDetail productDetail=new ProductDetail();
        productDetail.setDetail("Mehsul haqqinda az");
        productDetail.setLang("az");
        productDetail.setName("Mehsulun adi az");
        productDetail.setProduct(product);

        log.info("product detail az {} ",productDetail);

        ProductDetail productDetailen=new ProductDetail();
        productDetailen.setDetail("About  product en");
        productDetailen.setLang("en");
        productDetailen.setName("Product name en ");
        productDetailen.setProduct(product);
        log.info("product detail en {} ",productDetailen);
        ProductDetail productDetailru=new ProductDetail();
        productDetailru.setDetail("O produkte ru");
        productDetailru.setLang("ru");
        productDetailru.setName("Produckt imya   ru");
        productDetailru.setProduct(product);
        log.info("product detail ru {} ",productDetailru);
        productDetailRepository.save(productDetail);
        productDetailRepository.save(productDetailen);
        productDetailRepository.save(productDetailru);*/

    }
}
