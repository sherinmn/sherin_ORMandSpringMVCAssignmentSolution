<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Customer Registration</title>
</head>
<body>
	<br>
	<br>
	<div class="container">
		<h2 style="text-align: center">Customer Relationship Management</h2>
		<hr>
		<!-- <form action="/customer_relationship_management_app/customers/search"
			class="form-inline">-->

		<!-- Add a button -->
		<form style="text-align: right">
			<br>
			<a
				href="/customer_relationship_management_app/customers/showFormForAdd"
				class="btn btn-primary btn-sm mb-3"> Add Customer </a>
				
			<br>
			<br>
		</form>

		<table class="table table-bordered table-striped">
			<thead class="thead-dark" style="text-align: center">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email Id</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody style="text-align: center">
				<c:forEach items="${CustomerRelationshipMgt}" var="tempCustomer">
					<tr>
						<td><c:out value="${tempCustomer.firstName}" /></td>
						<td><c:out value="${tempCustomer.lastName}" /></td>
						<td><c:out value="${tempCustomer.email}" /></td>
						<td style="text-align: center">
							<!-- Add "update" button/link --> <a
							href="/customer_relationship_management_app/customers/showFormForUpdate?CustomerId=${tempCustomer.id}"
							class="btn btn-primary btn-sm"> Update </a> <a
							href="/customer_relationship_management_app/customers/delete?CustomerId=${tempCustomer.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>


</body>
</html>