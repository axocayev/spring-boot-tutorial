package az.atl.academy.hrapp.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean(name = "student1")
    public Student student1(){
        return  new Student();
    }

    @Bean(name = "student2")
    public Student student2(){
        return  new Student();
    }



}
