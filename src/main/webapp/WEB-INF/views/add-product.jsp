<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css" />
<title>Add Product</title>
</head>
<body>
	<h1>New Item Page</h1>
	<form method="post" action="/product/create">

		<fieldset>
			<legend>Product Info</legend>
			<table>
				<tr>
					<th scope="row">Name</th>
					<td><input type="text" name="name" autofocus /></td>
				</tr>
				<tr>
					<th scope="row">Description</th>
					<td><input type="text" name="description" /></td>
				</tr>
				<tr>
					<th scope="row">Price</th>
					<td><input type="number" step="any" name="price" /></td>
				</tr>
			</table>
		</fieldset>
		<button type="submit">Submit</button>
	</form>
</body>
</html>