<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<html>
<head>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
Id: <c:out value="${id}"/><br>
Name: <c:out value="${name}"/><br>
Email: <c:out value="${email}"/><br>

</body>
</html>
