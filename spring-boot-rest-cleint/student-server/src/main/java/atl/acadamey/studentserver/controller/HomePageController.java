package atl.acadamey.studentserver.controller;

import atl.acadamey.studentserver.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomePageController {
    StudentService studentService;

    public HomePageController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public @ResponseBody  String getHome() {
        return "Hello World";
    }
}
