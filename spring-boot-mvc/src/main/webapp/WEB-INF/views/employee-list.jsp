<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<html>
<head>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<c:forEach items="${employees}" var="emp">

Id: <c:out value="${emp.getId()}"/><br>
Name: <c:out value="${emp.getName()}"/><br>
Email: <c:out value="${emp.getEmail()}"/><br>
</c:forEach>
</body>
</html>
