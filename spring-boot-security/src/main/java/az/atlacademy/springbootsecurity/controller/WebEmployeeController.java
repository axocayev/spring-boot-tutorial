package az.atlacademy.springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class WebEmployeeController {

    @GetMapping("/login")
    public String login(Model model) {
        return "loginpage";
    }


    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "dashboard";
    }

}
