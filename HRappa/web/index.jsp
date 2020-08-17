<%@ page import="xocayev.dboperations.EmployeesDAO" %>
<%@ page import="xocayev.domain.Employee" %>
<%--
  Created by IntelliJ IDEA.
  User: anarx
  Date: 7/11/2020
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>TEst</title>
  </head>
  <body>
    Welcome to WEB
    <a href="home.html">Home </a>
   <table  border="1">
     <tr><th>ID</th><th>Ad</th><th>Soyad</th><th>Emeliyat</th></tr>


    <%
      EmployeesDAO employeesDAO=new EmployeesDAO();
      for(Employee e: employeesDAO.getEmployyeeList()){
        out.print("<tr>");
        out.print("<td> <a href='employee.jsp?id="+e.getEmployeeId()+"'>"+e.getEmployeeId()+ "</a></td>");
        out.print("<td>"+e.getFirstName()+"</td>");
        out.print("<td>"+e.getLastName()+"</td>");
          out.print("<td> <a href='employee.jsp?id="+e.getEmployeeId()+"&action=delete'>Sil</a></td>");

          out.print("</tr>");
      }
    %>
   </table>

  </body>
</html>
