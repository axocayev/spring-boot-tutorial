package xocayev.dboperations;

import xocayev.dbconfig.MySQLConfig;
import xocayev.domain.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO {
    String sql = "select * from employees";

    /*public void showEmployee(int empId){
        sql=sql+" where employee_id="+empId;
        showAllEmps();
    }*/


    public void showAllEmps() {
        MySQLConfig mySQLConfig = new MySQLConfig();


        try (Connection conn = mySQLConfig.getConnect()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.format("%4s", resultSet.getInt("employee_id") + " ");
                System.out.format("%15s", resultSet.getString("first_name") + " ");
                System.out.format("%15s", resultSet.getString("last_name") + " ");
                System.out.println();
            }
            resultSet.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mySQLConfig.close();
        }


    }


    public List<Employee> getEmployyeeList() {

        List<Employee> employyeeList = new ArrayList<>();

        MySQLConfig mySQLConfig = new MySQLConfig();


        try (Connection conn = mySQLConfig.getConnect()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Employee employees = new Employee();

                employees.setEmployeeId(resultSet.getInt("employee_id"));
                employees.setFirstName(resultSet.getString("first_name"));
                employees.setLastName(resultSet.getString("last_name"));
                employees.setEmail(resultSet.getString("email"));
                employees.setPhoneInt(resultSet.getString("phone_int"));
                employees.setHireDate(resultSet.getDate("hire_date"));
                employees.setJobId(resultSet.getString("job_id"));
                employees.setSalary(resultSet.getDouble("salary"));
                employees.setCommissionPct(resultSet.getDouble("commission_pct"));
                employees.setManagerId(resultSet.getInt("manager_id"));
                employees.setDepartId(resultSet.getInt("department_id"));
                employyeeList.add(employees);
            }
            resultSet.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mySQLConfig.close();
        }


        return employyeeList;

    }

    public int deleteEmployeeById(int id) {



        MySQLConfig mySQLConfig = new MySQLConfig();
         int result=0;

        try (Connection conn = mySQLConfig.getConnect()) {

            PreparedStatement ps = conn.prepareStatement("delete from employees  where employee_id=?");
            ps.setInt(1,id);
            result = ps.executeUpdate();

            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mySQLConfig.close();
        }


        return result;

    }
    public Employee getEmployeeById(int id) {



        MySQLConfig mySQLConfig = new MySQLConfig();
        Employee employees = new Employee();

        try (Connection conn = mySQLConfig.getConnect()) {

            PreparedStatement ps = conn.prepareStatement(sql +" where employee_id=?");
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {


                employees.setEmployeeId(resultSet.getInt("employee_id"));
                employees.setFirstName(resultSet.getString("first_name"));
                employees.setLastName(resultSet.getString("last_name"));
                employees.setEmail(resultSet.getString("email"));
                employees.setPhoneInt(resultSet.getString("phone_int"));
                employees.setHireDate(resultSet.getDate("hire_date"));
                employees.setJobId(resultSet.getString("job_id"));
                employees.setSalary(resultSet.getDouble("salary"));
                employees.setCommissionPct(resultSet.getDouble("commission_pct"));
                employees.setManagerId(resultSet.getInt("manager_id"));
                employees.setDepartId(resultSet.getInt("department_id"));

            }
            resultSet.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mySQLConfig.close();
        }


        return employees;

    }


    public String newEmployee(Employee e) {
        MySQLConfig mySQLConfig = new MySQLConfig();
        String sql = "insert into employees values (?,?,?,?,?,?,?,?,?,?,?)";
        String result=null;
        try (Connection conn = mySQLConfig.getConnect()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, e.getEmployeeId());
            ps.setString(2, e.getFirstName());
            ps.setString(3, e.getLastName());
            ps.setString(4, e.getEmail());
            ps.setString(5, e.getPhoneInt());
            ps.setDate(6, e.getHireDate());
            ps.setString(7, e.getJobId());
            ps.setDouble(8, e.getSalary());
            ps.setDouble(9, e.getCommissionPct());
            ps.setInt(10, e.getManagerId());
            ps.setInt(11, e.getDepartId());

            int status = ps.executeUpdate();
            result = status == 1 ? "SUCCESS" : "FAILED";

        } catch (Exception eex) {
            eex.printStackTrace();
            result=eex.getMessage();
        } finally {
            mySQLConfig.close();
        }

        return result;
    }


    public String updateEmployee(Employee e) {
        MySQLConfig mySQLConfig = new MySQLConfig();
        String sql = "update employees set  first_name=?,last_name=?,email=?,phone_int=?,hire_date=?,job_id=?,salary=?,commission_pct=?,manager_id=?,department_id=? where employee_id=?";
        String result=null;
        try (Connection conn = mySQLConfig.getConnect()) {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, e.getFirstName());
            ps.setString(2, e.getLastName());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getPhoneInt());
            ps.setDate(5, e.getHireDate());
            ps.setString(6, e.getJobId());
            ps.setDouble(7, e.getSalary());
            ps.setDouble(8, e.getCommissionPct());
            ps.setInt(9, e.getManagerId());
            ps.setInt(10, e.getDepartId());
            ps.setInt(11, e.getEmployeeId());

            int status = ps.executeUpdate();
            result = status == 1 ? "SUCCESS" : "NO ROW UPDATED";

        } catch (Exception eex) {
            eex.printStackTrace();
            result=eex.getMessage();
        } finally {
            mySQLConfig.close();
        }

        return result;
    }

}
