package az.atl.academy.hrapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @Value("${spring.application.name}")
    String appname;

    @GetMapping("/test")
    public @ResponseBody String test(){
        return appname;
    }

   /* @PostMapping("/student")
    public  @ResponseBody  Student stduent(){
        Student student=new Student("Anar","Xocayev","anarxocayev@gmail.com",35);
        return student;
    }*/


   // @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/home")
    public String index(){
        return "index";
    }

}
/*
class Student{
    String name;
    String surname;
    String email;
    Integer age;

    public Student(String name, String surname, String email, Integer age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
*/
