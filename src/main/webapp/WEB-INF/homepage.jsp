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
		<h1 class="text-light">
			Welcome
			<c:out value="${user.username }" />
		</h1>
		<a class="btn btn-sm btn-danger mb-3" href="/logout"> Log Out </a>
		<div>
			<a href="/book/form"> Add Book</a>
		</div>
		<div class="d-flex justify-content-center">
			<div class="card text-bg-success mb-3 " style="max-width: 35rem;">
				<div class="card-header">Your Favorite Books!</div>
				<div class="card-body">
					<table class="text-light">
						<thead>
							<tr>
								<th class="text-warning">Title:</th>
								<th class="text-warning ">Author:</th>
								<th class="text-warning ">My Thoughts:</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="book" items="${books}">
								<tr>
									<td><a class="btn btn-sm btn-info mb-3"
										href="/view/book/${book.id}"> View</a>
									<c:out value="${book.title}" /></td>
									<td><c:out value="${book.author}" /></td>
									<td><c:out value="${book.myThoughts}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>

</body>
</html>