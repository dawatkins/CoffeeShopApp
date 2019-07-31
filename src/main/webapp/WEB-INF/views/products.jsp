<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css" />
</head>
<body>
	<header>
		<span>
			Current User: ${ preference.name }
		</span>
	</header>
	<div class="container">
		<h1>Products</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th><th>Description</th><th>Price</th><th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
				<tr>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td>
					<!-- <a href="/products/update?id=${ product.id }" class="btn btn-light btn-sm">Edit</a> -->
					<a href="/product/update?id=${ product.id }" class="btn btn-light btn-sm">Edit</a>
					<a href="/products/delete?id=${ product.id }" class="btn btn-light btn-sm">Delete</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-secondary" href="/product/create">Add</a>
		<a class="btn btn-secondary" href="/">Home</a>
	</div>
</body>
</html>