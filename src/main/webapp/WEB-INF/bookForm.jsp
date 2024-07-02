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
		<h1 class="text-light">Add your Favorite Book!</h1>
		<div class="d-flex justify-content-center">
			<div class="card text-bg-success mb-3 " style="max-width: 18rem;">
				<div class="card-header">Enter your favorite book info here!</div>
				<div class="card-body">
					<form:form action="/create/book" method="post"
						modelAttribute="book">
						<div>
							<form:label path="title">Title:</form:label>
							<form:errors class="text-light" path="title" />
							<form:input class="mb-3" path="title" />
						</div>
						<div>
							<form:label path="author">Author:</form:label>
							<form:errors class="text-light" path="author" />
							<form:input class="mb-3" path="author" />
						</div>
						<div>
							<form:label path="myThoughts">My Thoughts:</form:label>
							<form:errors class="text-light" path="myThoughts" />
							<form:textarea class="mb-3" path="myThoughts" />
						</div>
						<input type="submit" class="btn btn-warning mt-3" value="Submit" />
					</form:form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>