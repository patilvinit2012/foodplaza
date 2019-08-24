<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<style>
body {
	display: flex;
	min-height: 100vh;
	flex-direction: column;
}

main {
	flex: 1 0 auto;
}

body {
	background: #fff;
}
</style>
</head>
<jsp:include page="../header.jsp" />
<body>
	<main>
	<center>

		<h5 class="indigo-text">Please, login into your account</h5>
		<div class="section"></div>

		<div class="container">
			<div class="z-depth-1 grey lighten-4 row"
				style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">

				<form class="col s12" method="post">
					<div class='row'>
						<div class='col s12'></div>
					</div>

					<div class='row'>
						<div class='input-field col s12'>
							<input class='validate' type='email' name='email' id='email' />
							<label for='email'>Enter your email</label>
						</div>
					</div>

					<div class='row'>
						<div class='input-field col s12'>
							<input class='validate' type='password' name='password'
								id='password' /> <label for='password'>Enter your
								password</label>
						</div>
						<label style='float: right;'> <a class='pink-text'
							href='#!'><b>Forgot Password?</b></a>
						</label>
					</div>

					<br />
					<center>
						<div class='row'>
							<button type='submit' name='btn_login'
								class='col s12 btn btn-large waves-effect indigo'>Login</button>
						</div>
					</center>
				</form>
			</div>
		</div>
		<spring:url value="/user/add" var="registerURL"/>
		<a href="${registerURL}">Create account</a>
	</center>

	</main>


</body>

</html>
<jsp:include page="../footer.jsp" />