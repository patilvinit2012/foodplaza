<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">

<title>Add new Role</title>
</head>
<jsp:include page="../header.jsp" />
<body>
	<main>
	<div class="container">
		<div class="row">
			<form:form class="col s12" modelAttribute="role" method="POST">
				<div class="row">
					<div class="input-field col s12">
						<i class="material-icons prefix">account_circle</i>
						<form:input path="roleName" class="validate"
							placeholder="roleName" />
						<label for="roleName">RoleName</label>
					</div>
				</div>
				<button class="btn waves-effect waves-light" type="submit"
					name="action">
					Save <i class="material-icons right">send</i>
				</button>
			</form:form>
		</div>
	</div>
	</main>
</body>
<jsp:include page="../footer.jsp"/>
</html>