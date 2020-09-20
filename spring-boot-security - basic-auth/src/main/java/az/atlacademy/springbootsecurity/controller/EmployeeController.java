package az.atlacademy.springbootsecurity.controller;

import az.atlacademy.springbootsecurity.entity.Employee;
import az.atlacademy.springbootsecurity.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
@AllArgsConstructor
@Slf4j
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping(value = "/")
    public Employee save(@RequestBody Employee employeee) {
        log.info("employee request {}", employeee);
        Employee e = employeeService.save(employeee);
        log.info("employee response  {}", e);
        return e;
    }

    @GetMapping(value = "/list")
    public List<Employee> list() {

        List<Employee> e = employeeService.getList();
        log.info("employee list response  {}", e);
        return e;
    }
    @GetMapping(value = "/")
    public Employee  getByUd(@RequestParam("employeeId") Long id) {
         log.info("request id {}",id);
        Employee e = employeeService.findById(id);
        log.info("employee list response  {}", e);
        return e;
    }


    @GetMapping(value = "/test")
    public List<Employee> test() {

        List<Employee> e = employeeService.getList();
        log.info("employee test  list response  {}", e);
        return e;
    }

}
