<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css" />
</head>
<body>
	<main class="container">
		<h1>${ title }</h1>
		
		<!-- A form without an action submits back to the same URL, which is what we want here. -->
		<form method="post">
			<!-- We need to keep the ID and submit it with the form, but we don't want the user to have to see it. -->
			<input type="hidden" name="id" value="${product.id}" />
			<div class="form-group">
			    <label for="name">Name</label>
			    <!-- pre-populate the input value from the existing food (if any) -->
			    <input class="form-control" id="name" name="name" value="${product.name}" required minlength="2" autocomplete="off">
			</div>
			<div class="form-group">
			    <label for="description">Description</label>
			    <input class="form-control" id="description" name="description" value="${product.description}" required minlength="3">
			</div>
			<div class="form-group">
				<label for="price">Price</label>
				<input class=form-control" id="price" name="price" value="${product.price}">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="/products" class="btn btn-link">Cancel</a>
		</form>
	</main>
</body>
</html>