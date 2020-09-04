<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">


<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Inline form</h2>
    <p>Make the viewport larger than 768px wide to see that all of the form elements are inline, left aligned, and the
        labels are alongside.</p>
    <form:form role="form" class="form-veritical"
               action="/products/save" method="post"
               modelAttribute="product">
        <div class="form-group">
            <label for="name">Name:</label>
            <form:input type="text" path="name" class="form-control" id="name" placeholder="Enter name" name="name"/>
            <form:errors path="name" cssStyle="color: red"></form:errors>
        </div>
        <div class="form-group">
            <label for="Desciption">Desciption:</label>
            <form:input type="text" path="description" class="form-control" id="Desciption" placeholder="Desciption"
                        name="description"/>
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <form:input type="number" path="price" class="form-control" id="price" placeholder="Price" name="price"/>
        </div>
        <div class="form-group">
            <label for="company">Company:</label>
            <form:input type="text" path="company" class="form-control" id="company" placeholder="company" name="company"/>
        </div>
        <div class="form-group">
            <label>Status:</label>
            0/1 <form:input type="number"  path="status"   placeholder="0/1" name="status"/>
            <form:errors path="status" cssStyle="color: red"></form:errors>
        </div>

        <button type="submit" class="btn btn-default">Submit</button>
    </form:form>
</div>

</body>
</html>
