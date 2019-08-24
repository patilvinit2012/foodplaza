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

<title>Al users</title>
</head>

<jsp:include page="../header.jsp" />
<body>
	<main>
	<div class="container">
		<h3>Users</h3>
		<div class="row">
			<table class="highlight centered responsive-table">
				<thead>
					<tr>
						<th>User Id</th>
						<th>User name</th>
						<th>First name</th>
						<th>Last name</th>
						<th>Assigned Roles</th>
						<th>Actions</th>
					</tr>
				</thead>

				<tbody class="user-list">
					<c:forEach items="${users}" var="user">
						<tr id="${user.userId}" class="hoverable">
							<td>${user.userId}</td>
							<td>${user.userName}</td>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td>
								<a class="modal-trigger viewRoles" href="#roleListModal">
									View Roles
								</a>
							</td>
							<td>
								<!-- <i class="material-icons">edit</i> 
						<i class="material-icons">save</i> --> <i
								class="material-icons m-icon-red delete-user tooltipped"
								data-position="right" data-tooltip="Delete?"
								data-delete-user-id="${user.userId}">delete_forever</i>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div>
			<div id="roleListModal" class="modal bottom-sheet"><!-- modal-fixed-footer -->
				<div class="modal-content">
					<h4>Assigned Roles</h4>
					<div>
						<ul class="collection" id="roleModelList"></ul>
					</div>
				</div>
			</div>
		</div>

		<div>
			<div class="fixed-action-btn">
				<a
					class="btn-floating btn-large waves-effect waves-light blue tooltipped"
					href="add" data-position="top" data-tooltip="Add new user"> <i
					class="material-icons">add</i>
				</a>
			</div>
		</div>
	</div>
	</main>
</body>
<jsp:include page="../footer.jsp" />
<script type="text/javascript">
	$(document).ready(function() {
		$('.tooltipped').tooltip();
	});

	$(document).ready(function() {
		$('.modal').modal();
	});
	$('.delete-user').on('click', function() {
		var userId = $(this).data("delete-user-id");
		$.ajax({
			url : userId,
			type : 'DELETE',
			success : function(res) {
				if (res) {
					console.log(this);
					$('.user-list').find('tr#' + userId).remove()
				}
			}
		})
	})
	
	$('.viewRoles').on('click',function(){
		var id = $(this).closest('tr').attr('id');
		$.ajax({
			url: "roles/"+id,
			success: function(roles){
				if(roles){
					$('#roleModelList').empty();
					$('#roleModelList').append(roles.map(role => `<li class="collection-item center-align">\${role.roleName}</li>`).join(" "));
				}
			}
		});
	})
</script>
</html>