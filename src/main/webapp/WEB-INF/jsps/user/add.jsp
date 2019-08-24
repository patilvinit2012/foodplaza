<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">


<title>Add new User</title>
</head>
<jsp:include page="../header.jsp"/>
<body>
	<main>
	<div class="section"></div>
	<div class="container">
		<div class="row">
			<div class="col s3"></div>
			<div class="col s6">
				<form:form class="col s12" modelAttribute="user" method="POST">
					<div class="row">
						<div class="input-field col s12">
							<form:input path="firstName" class="validate"
								autofocus="autofocus" />
							<label for="first_name">First Name</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<form:input path="lastName" class="validate" />
							<label for="last_name">Last Name</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="material-icons prefix">account_circle</i>
							<form:input path="userName" type="email" class="validate" />
							<label for="email">Email</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<i class="material-icons prefix">vpn_key</i>
							<form:input path="password" type="password" class="validate" />
							<label for="password">Password</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<form:select multiple="true" path="roleStr">
								<option value="" disabled selected>Choose roles</option>
								<form:options items="${user.roles}" itemValue="roleId" itemLabel="roleName"/>
							</form:select> 
							
						</div>
					</div>
					<div class="row">
						<div class="col s4"></div>
						<div class="col s4">
							<button class="btn waves-effect waves-light" type="submit"
								name="action">
								Save <i class="material-icons right">send</i>
							</button>
						</div>
						<div class="col s4"></div>
					</div>

				</form:form>
			</div>
			<div class="col s3"></div>

		</div>
	</div>
	</main>
</body>
<jsp:include page="../footer.jsp"/>
<script>
	$(document).ready(function() {
		$('select').formSelect();
	});
</script>
</html>