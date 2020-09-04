package az.atlacademy.valdiations.validator;

import az.atlacademy.valdiations.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
@Slf4j
public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product=(Product) o;
      if(product.getName().length()<5 || product.getName().length()>30){
          errors.rejectValue("name","product.name.length");
      }
        if(product.getStatus()!=1 && product.getStatus()!=0){
            errors.rejectValue("status","product.status.invalid");
        }

    }
}
