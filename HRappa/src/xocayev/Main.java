package xocayev;

import xocayev.dboperations.EmployeesDAO;
import xocayev.domain.Employee;

import java.sql.Date;
import java.time.LocalDateTime;

//import com.mysql.cj.jdbc.Driver
public class Main {

    public static void main(String[] args) {
       /* System.out.println("test");

        MySQLConfig mySQLConfig=new MySQLConfig();

        System.out.println(mySQLConfig.getConnect());
        mySQLConfig.close();*/
        EmployeesDAO employeesDAO=new EmployeesDAO();
     //   employeesDAO.showAllEmps();

        //employeesDAO.showAllEmps();


        //DepartmentsDAO departmentsDAO=new DepartmentsDAO();
       //String s= departmentsDAO.addNewDept("Test Dept",700,105,1700);
        //String s=departmentsDAO.deleteept(700);
        //System.out.println("Status :"+s);
        /*System.out.println("----------------STREAM --------------------------");
        employeesDAO.getEmployyeeList().stream().forEach(System.out::println);
        System.out.println("----------------LIST --------------------------");
        System.out.println(employeesDAO.getEmployyeeList());

        System.out.println("----------------FOR--------------------------");
        for (Employee e:employeesDAO.getEmployyeeList()){
            System.out.println(e);
        }
        System.out.println("----------------ITEARTOR--------------------------");
        Iterator<Employee> iterator =employeesDAO.getEmployyeeList().iterator();
        while(iterator.hasNext()){
            Employee e=iterator.next();
            System.out.println(e);
        }
        System.out.println("----------------STREAM FILTER--------------------------");
        employeesDAO.getEmployyeeList().stream().filter(emp->emp.getSalary()>15000).forEach(System.out::println);
*/
        LocalDateTime dt=LocalDateTime.parse("2020-06-30T12:00:00");
        Date hireDate= Date.valueOf(dt.toLocalDate());

        Employee e=new Employee(333,"Anar","Xocayev","AXOCAYE","055.611.21.16",hireDate,"AC_ACCOUNT",2000.00,null,103,90);
       // System.out.println(employeesDAO.newEmployee(e))   ;
        System.out.println(employeesDAO.updateEmployee(e));
        employeesDAO.getEmployyeeList().stream().forEach(System.out::println);
    }


}
