package az.atlacademy.testing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Customer getCustomer() {
       return new  Customer("Anar","Xocayev");
    }

}

