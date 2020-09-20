package az.atlacademy.testing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {//pageController
    @GetMapping("/home")
    public  @ResponseBody  String  getHomePage(){
        return "Hello World";
    }

}
