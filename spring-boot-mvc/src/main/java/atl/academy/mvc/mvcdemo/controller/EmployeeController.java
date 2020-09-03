package atl.academy.mvc.mvcdemo.controller;

import atl.academy.mvc.mvcdemo.entity.EmployeeEntity;
import atl.academy.mvc.mvcdemo.service.EmployeeService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @RequestMapping(value = "/employee/list", method = RequestMethod.GET)
    public ModelAndView employeeList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employees",employeeService.getAllEmp());
        modelAndView.setViewName("employee-list");
        return modelAndView;
    }
@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public ModelAndView getEmployee(@PathVariable(name = "id") Long id) {
        System.out.println("Id " + id);
        ModelAndView modelAndView = new ModelAndView();
        EmployeeEntity employeeEntity=employeeService.getById(id);
        modelAndView.addObject("name",employeeEntity.getName());
        modelAndView.addObject("email",employeeEntity.getEmail());
        modelAndView.addObject("id",employeeEntity.getId());
        modelAndView.setViewName("employee-detail");
        return modelAndView;
    }

    @RequestMapping(value = "/employee/new", method = RequestMethod.GET)
    public ModelAndView newEmployee() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employee",new EmployeeEntity());
        modelAndView.setViewName("form-employee");
        return modelAndView;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") EmployeeEntity employeeEntity) {
         employeeService.saveEmployee(employeeEntity);
         return "redirect:/employee/list";
    }

}
