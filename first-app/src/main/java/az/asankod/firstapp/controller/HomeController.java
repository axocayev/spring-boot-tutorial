package az.asankod.firstapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping({"/","/home"})
    public ModelAndView homePage(){
        ModelAndView andView =new ModelAndView();
        andView.setViewName("home");
        return andView;
    }

}
