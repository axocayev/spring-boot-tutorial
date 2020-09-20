package az.atlacademy.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class MyController {
    Logger logger = LoggerFactory.getLogger(MyController.class);

    @GetMapping("/hello")
    @ResponseBody
    public String getHello(@RequestParam("name")String name) throws Exception {
        logger.debug("name {}" ,name);
        logger.info("name  {} ",name);
        logger.warn("name {} ",name);
        if(name.length()>10 ){
            logger.error("name length {}" ,name);
            throw  new Exception("Error length");
        }
        return "Hello";
    }


}
