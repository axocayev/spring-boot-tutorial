package atl.academy.mvc.mvcdemo.service;

import atl.academy.mvc.mvcdemo.entity.EmployeeEntity;
import atl.academy.mvc.mvcdemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity){
        return  employeeRepository.save(employeeEntity);
    }

    public  EmployeeEntity  getById(Long id){
        return  employeeRepository.getOne(id);
    }

    public List<EmployeeEntity > getAllEmp(){
        return employeeRepository.findAll();
    }
}
