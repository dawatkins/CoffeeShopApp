<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css" />
</head>
<body>
	<h1>Registration Page</h1>
	<form method="post" action="/register-results">

		<fieldset>
			<legend>Contact Info</legend>
			<table>
				<tr>
					<th scope="row">Name</th>
					<td><input type="text" name="name" autofocus/></td>
				</tr>
				<tr>
					<th scope="row">email</th>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<th scope="row">Password</th>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>
		</fieldset>
		<button type="submit">Submit</button>
		
	</form>
	<a href="/"><button>Cancel</button></a>
</body>
</html>