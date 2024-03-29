<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/spacelab/bootstrap.min.css" />
</head>
<body>
	<header> <span> Current User: ${ user.name } </span> </header>
	<div class="container">
		<h1>Welcome to the GC Coffee Shop!</h1>
		<p><a href="/products"><button>List of products!</button></a> <a href="/register"><button>Click to Register</button></a></p>
		<p>
		<c:if test="${ empty user }">
			<a href="/login"><button>Log in</button></a>
		</c:if>
		<c:if test="${ not empty user }">
			Welcome ${ user.name }
			<a href="/logout"><button>Log out</button></a>
		</c:if>
		</p>
	</div>
</body>
</html>