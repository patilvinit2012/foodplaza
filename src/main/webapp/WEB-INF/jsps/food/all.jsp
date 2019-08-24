<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<style type="text/css">
.material-icons.m-icon-red {
	color: red;
}

.material-icons {
	cursor: pointer;
}
</style>

<title>Al foods</title>
</head>

<jsp:include page="../header.jsp"></jsp:include>
<body>
	<main>
	<div class="container">
		<h3>Foods</h3>
		<div class="row">
			<c:forEach items="${foods}" var="food">
				<div class="col m6 l4">
					<div class="card medium hoverable">
						<div class="card-image waves-effect waves-block waves-light">
							<img class="activator" src="data:image/jpeg;base64,${food.foodImageData}">
						</div>
						<div class="card-content">
							<span class="card-title activator grey-text text-darken-4">
								${food.foodName}<i class="material-icons right">more_vert</i>
							</span>
							<p>
								<a href="#">Edit</a>
							</p>
							<div>
								<c:set var="vegNonVegColor" value="red"/>
								<c:if test="${food.foodType eq 'VEG'}">
									<c:set var="vegNonVegColor" value="green"/>
								</c:if>
								<span class="new badge ${vegNonVegColor}" data-badge-caption="${food.foodType}"></span>
							</div>
							<div>
								<span class="new badge green" data-badge-caption="${food.foodPrice} Rs"></span>
							</div>
							<div>${food.foodQty} available in stock</div>
							<br>
							
						</div>
						<div class="card-reveal">
							<span class="card-title grey-text text-darken-4">
								${food.foodName}
								<i class="material-icons right">close</i></span>
							<p>${food.foodDesc}</p>
							<div>
								<a class="waves-effect waves-light btn btn-small"><i class="material-icons left">add_shopping_cart</i>Cart</a>
							
								<a class="waves-effect waves-light btn btn-small"><i class="material-icons left">skip_next</i>Buy now</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div>
			<div class="fixed-action-btn">
				<a
					class="btn-floating btn-large waves-effect waves-light blue tooltipped"
					href="add" data-position="top" data-tooltip="Add new food"> <i
					class="material-icons">add</i>
				</a>
			</div>
		</div>
	</div>
	</main>
</body>
<jsp:include page="../footer.jsp"/>
<script type="text/javascript">
	$(document).ready(function() {
		$('.tooltipped').tooltip();
	});

	$(document).ready(function() {
		$('.modal').modal();
	});
	$('.delete-food').on('click', function() {
		var foodId = $(this).data("delete-food-id");
		$.ajax({
			url : foodId,
			type : 'DELETE',
			success : function(res) {
				if (res) {
					console.log(res);
					$('.food-list').find('tr#' + foodId).remove()
				}
			}
		})
	})
</script>
</html>