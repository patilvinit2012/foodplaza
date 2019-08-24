<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Add new Food</title>
</head>
<jsp:include page="../header.jsp"/>
<body>
	<main>
	<div class="container">
		<div class="row">
			<div class="col s3"></div>
			<div class="col s6">
				<form:form class="col s12" modelAttribute="food" method="POST" enctype="multipart/form-data">
				<form:hidden path="foodId"/>
					<div class="row">
						<div class="input-field col s12">
							<form:input path="foodName" class="validate"
								autofocus="autofocus" />
							<label for="foodName">Food Name</label>
						</div>
					</div>
					<div class="row">
				      <label>
				        <form:radiobutton path="foodType" value="VEG" class="validate"/>
				        <span>Veg</span>
				      </label>
				    
				      <label>
				        <form:radiobutton path="foodType" value="NON-VEG" class="validate"/>
				        <span>Non-Veg</span>
				      </label>
					</div>
					
					<div class="row">
						<div class="input-field col m6 s6">
							<form:input type="number" path="foodPrice" class="validate" min="0.00" step="any"/>
							<label for=foodPrice>Price per item</label>
						</div>
					
						<div class="input-field col m6 s6">
							<form:input type="number" path="foodQty" class="validate" min="0" step="1"/>
							<label for=foodQty>Quantity</label>
						</div>
					</div>
					<div class="row">
				        <div class="input-field col s12">
				          <form:textarea path="foodDesc" class="materialize-textarea"/>
				          <label for="foodDesc">Description</label>
				        </div>
			      	</div>
			      	<div class="row">
			      		<div class="file-field input-field">
							<div class="btn">
								<span><i class="material-icons">cloud_upload</i></span>
								<form:input type="file" path="foodImage"/>
							</div>
							<div class="file-path-wrapper">
								<input class="file-path validate" type="text">
							</div>
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
<script>
</script>
</html>
<jsp:include page="../footer.jsp"/>