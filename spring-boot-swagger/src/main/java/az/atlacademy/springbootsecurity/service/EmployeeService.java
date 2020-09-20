package az.atlacademy.springbootsecurity.service;

import az.atlacademy.springbootsecurity.entity.Employee;
import az.atlacademy.springbootsecurity.repositort.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee){
        return  employeeRepository.save(employee);
    }
    public List<Employee> getList(){
        return  employeeRepository.findAll();
    }
    public  Employee findById(Long id){
        return  employeeRepository.getOne(id);
    }
}
