<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<div class="container text-center bg-dark">
		<h1 class="text-light">Book info:</h1>
		<a class="btn btn-sm btn-danger mb-3" href="/logout"> Log Out </a> <a
			class="btn btn-sm btn-primary mb-3" href="/homepage"> Home </a>
		<div class="d-flex justify-content-center">
			<table class="text-light">
				<thead>
					<tr>
						<th class="text-danger">Title</th>
						<th class="text-danger p-3">Author</th>
						<th class="text-danger">Thoughts</th>
					</tr>

				</thead>
				<tbody>
					<tr class="p-3">
						<td><c:out value="${books.title}" /></td>
						<td><c:out value="${books.author}" /></td>
						<td><c:out value="${books.myThoughts}" /></td>
						<td>
							<c:if test ="${userId == books.user.id }">
							<form action="/delete/book/${books.id}" method="post">
								<input type="hidden" name="_method" value="delete"> <input
									type="submit" class="btn btn-danger btn-sm " value="Delete">
							</form> 
							<a class="btn btn-sm btn-info mb-3"
										href="/edit/book/${books.id}"> Edit </a>
							</c:if>
							
						</td>
					</tr>
				</tbody>
			</table>
			
						
		</div>
	</div>
</body>
</html>
