<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">

<style type="text/css">
.material-icons.m-icon-red {
	color: red;
}

.material-icons {
	cursor: pointer;
}
</style>

<title>Al roles</title>
</head>
<jsp:include page="../header.jsp"/>
<body>
	<main>
	<div class="container">
		<h3>Roles</h3>
		<table class="highlight centered responsive-table">
			<thead>
				<tr>
					<th>Role Id</th>
					<th>Role name</th>
					<th>Actions</th>
				</tr>
			</thead>

			<tbody class="role-list">
				<c:forEach items="${roles}" var="role">
					<tr id="${role.roleId}" class="hoverable">
						<td>${role.roleId}</td>
						<td>${role.roleName}</td>
						<td>
							<!-- <i class="material-icons">edit</i> 
						<i class="material-icons">save</i>  --> <i
							class="material-icons m-icon-red delete-role tooltipped"
							data-position="right" data-tooltip="Delete?"
							data-delete-role-id="${role.roleId}">delete_forever</i>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div>
			<!-- Modal Trigger -->
			<a class="waves-effect waves-light btn modal-trigger"
				href="#deleteRoleModal">Modal</a>

			<!-- Delete Role Popup -->
			<div id="deleteRoleModal" class="modal">
				<div class="modal-content">
					<h4>Delete Role</h4>
				</div>
				<div class="modal-footer">
					<a href="#!" class="modal-close waves-effect waves-red btn-flat">Cancel</a>
					<a href="#!" class="modal-close waves-effect waves-green btn-flat">Agree</a>
				</div>
			</div>
		</div>

		<div>
			<div class="fixed-action-btn">
				<a
					class="btn-floating btn-large waves-effect waves-light blue tooltipped"
					href="add" data-position="top" data-tooltip="Add new role"> <i
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
			$('.delete-role').on('click', function(ele, a, b) {
				var roleId = $(this).data("delete-role-id");
				$.ajax({
					url : roleId,
					type : 'DELETE',
					success : function(res) {
						if (res) {
							console.log(res);
							$('.role-list').find('tr#' + roleId).remove()
						}
					}
				})
			})
		</script>
</html>