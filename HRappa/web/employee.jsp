<%@ page import="xocayev.dboperations.EmployeesDAO" %>
<%@ page import="xocayev.domain.Employee" %><%--
  Created by IntelliJ IDEA.
  User: anarx
  Date: 7/11/2020
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
     int id= Integer.parseInt(  request.getParameter("id"));
      String action=null;
     try {
          action= request.getParameter("action");
     }catch (NullPointerException e){

     }
      EmployeesDAO employeesDAO=new EmployeesDAO();

      Employee employee=employeesDAO.getEmployeeById(id);
     // out.print(employee);
      out.print("ID : "+employee.getEmployeeId()+"<br>");
      out.print("Ad : "+employee.getFirstName()+"<br>");
      out.print("Soyad : "+employee.getLastName()+"<br>");
      out.print("Email : "+employee.getEmail()+"<br>");
      out.print("Telefon : "+employee.getPhoneInt()+"<br>");

      if (action !=null && action.equals("delete") ){
          out.print(employeesDAO.deleteEmployeeById(id));
      }


  %>
</body>
</html>
