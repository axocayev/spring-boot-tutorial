package az.atlacademy.springbootsecurity.repositort;

import az.atlacademy.springbootsecurity.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
}
