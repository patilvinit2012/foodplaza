<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<spring:url value="/css/materialize.min.css" var="materialCssUrl" />
<link rel="stylesheet" href="${ materialCssUrl }"
	media="screen,projection">

<spring:url value="/js/jquery-3.4.1.min.js" var="jQueryUrl" />
<script src="${jQueryUrl}"></script>

</head>
<body>
	<div class="navbar-fixed">
		<nav>
			<div class="nav-wrapper">

				<a href="#" class="brand-logo">Logo</a> <a href="#"
					data-target="mobile-demo" class="sidenav-trigger"><i
					class="material-icons">menu</i></a>
				<ul id="nav-mobile" class="right hide-on-med-and-down">

					<li>
						<form>
							<div class="input-field">
								<input id="search" type="search" required> 
								<label class="label-icon" for="search">
								<i class="material-icons">search</i></label> <i class="material-icons">close</i>
							</div>
						</form>
					</li>

					<spring:url value="/user/all" var="allUsersURL" />
					<li><a href="${allUsersURL}">Users</a></li>

					<spring:url value="/role/all" var="allRolesURL" />
					<li><a href="${allRolesURL}">Roles</a></li>

					<spring:url value="/food/all" var="allFoodsURL" />
					<li><a href="${allFoodsURL}">Foods</a></li>

					<li><a class="dropdown-trigger" href="#!"
						data-target="rolesDropdown"> Role <i
							class="material-icons right">arrow_drop_down</i>
					</a></li>

					<li><a class="dropdown-trigger" href="#!"
						data-target="accountDropdown"> <i class="material-icons">account_circle</i>
							<i class="material-icons right">arrow_drop_down</i>
					</a></li>
				</ul>
			</div>
		</nav>
		<ul id="rolesDropdown" class="dropdown-content">
			<li><a href="#!">USER</a></li>
			<li><a href="#!">ADMIN</a></li>
		</ul>
		<ul id="accountDropdown" class="dropdown-content">
			<li><a href="#!">Settings</a></li>
			<li class="divider"></li>
			<spring:url value="/login/" var="loginURL" />
			<li><a href="${loginURL}">Login</a></li>
			<li><a href="#!">Logout</a></li>
		</ul>
		<ul class="sidenav" id="mobile-demo">
			<spring:url value="/user/all" var="allUsersURL" />
			<li><a href="${allUsersURL}">Users</a></li>

			<spring:url value="/role/all" var="allRolesURL" />
			<li><a href="${allRolesURL}">Roles</a></li>

			<spring:url value="/food/all" var="allFoodsURL" />
			<li><a href="${allFoodsURL}">Foods</a></li>

			<li><a class="dropdown-trigger" href="#!"
				data-target="rolesDropdown"> Role <i
					class="material-icons right">arrow_drop_down</i>
			</a></li>

			<li><a class="dropdown-trigger" href="#!"
				data-target="accountDropdown"> <i class="material-icons">account_circle</i>
					<i class="material-icons right">arrow_drop_down</i>
			</a></li>
		</ul>
		<ul id="slide-out" class="sidenav">
			<li><div class="user-view">
					<div class="background">
						<img src="images/office.jpg">
					</div>
					<a href="#user"><img class="circle" src="images/yuna.jpg"></a>
					<a href="#name"><span class="white-text name">John Doe</span></a> <a
						href="#email"><span class="white-text email">jdandturk@gmail.com</span></a>
				</div></li>
			<li><a href="#!"><i class="material-icons">cloud</i>First
					Link With Icon</a></li>
			<li><a href="#!">Second Link</a></li>
			<li><div class="divider"></div></li>
			<li><a class="subheader">Subheader</a></li>
			<li><a class="waves-effect" href="#!">Third Link With Waves</a></li>
		</ul>
		<a href="#" data-target="slide-out" class="sidenav-trigger"><i
			class="material-icons">menu</i></a>
	</div>
</body>
</html>