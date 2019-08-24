<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

	TODO: Redirect to login page 
	<spring:url value="/user/all" var="usersURL" />
	<a href="${usersURL}"> User List</a>
</body>
</html>