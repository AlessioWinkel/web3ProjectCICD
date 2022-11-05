<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="container">
		<header>
			<jsp:include page="nav.jspf"/>

		</header>
		<main>
			<h1>Home</h1>

			<form method="POST" action="Controller?command=LogIn" novalidate>

				<p class="form-group ${EmailClass}">
					<label class="control-label" for="email">Email</label>
					<a id="email" name="email">${param.name}</a>
				</p>
				<p class="form-group ${passwordClass}">
					<label class="control-label" for="password">Password</label>
					<input id="password" name="password" type="password">
				</p>


				<p><input type="submit" id="logIn" value="Log In"></p>

			</form>

		</main>
	</div>
</body>
</html>