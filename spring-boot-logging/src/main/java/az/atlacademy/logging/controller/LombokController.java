package az.atlacademy.logging.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class LombokController {

   @GetMapping("/lombok")
    @ResponseBody
    public String  getLombok(@RequestParam("name")String name){
       log.info("name  {}",name);

       return "lombok";
   }
}
