package xocayev.domain;

import java.sql.Date;
import java.util.Objects;

//POJO  MODEL   DOMAIN  ENTITY
public class Employee {
    private Integer  employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneInt;
    private Date hireDate;
    private String jobId;
    private Double salary;
    private Double commissionPct;
    private Integer managerId;
    private Integer departId;


    public Employee() {
    }

    public Employee(Integer employeeId, String firstName, String lastName, String email, String phoneInt, Date hireDate, String jobId, Double salary, Double commissionPct, Integer managerId, Integer departId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneInt = phoneInt;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.managerId = managerId;
        this.departId = departId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneInt() {
        return phoneInt;
    }

    public void setPhoneInt(String phoneInt) {
        this.phoneInt = phoneInt;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(Double commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }



    @Override
    public String toString() {
        return "Employees{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneInt='" + phoneInt + '\'' +
                ", hireDate=" + hireDate +
                ", jobId='" + jobId + '\'' +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ", managerId=" + managerId +
                ", departId=" + departId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employees = (Employee) o;
        return employeeId.equals(employees.employeeId) &&
                firstName.equals(employees.firstName) &&
                lastName.equals(employees.lastName) &&
                email.equals(employees.email) &&
                phoneInt.equals(employees.phoneInt) &&
                hireDate.equals(employees.hireDate) &&
                jobId.equals(employees.jobId) &&
                salary.equals(employees.salary) &&
                commissionPct.equals(employees.commissionPct) &&
                managerId.equals(employees.managerId) &&
                departId.equals(employees.departId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, email, phoneInt, hireDate, jobId, salary, commissionPct, managerId, departId);
    }

}
