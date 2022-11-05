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

			<c:choose>

				<%-- user is logged in -- show welcome and logout form --%>
				<c:when test="${sessionScope.user!=null}">

					<p>Welcome, ${user.firstName }</p>
					<form action="Controller?command=LogOut" method="POST">
						<input type="submit" id="LogOut" value="Log Out">
					</form>
				</c:when>
				<c:otherwise>
					<%-- no user is logged in -- show login form --%>
					<p>Please log in.</p>
					<form method="POST" action="Controller?command=LogIn" novalidate>

						<p class="form-group">
							<label class="control-label" for="email">Email</label>
							<input id="email" name="email" type="text">
						</p>
						<p class="form-group">
							<label class="control-label" for="password">Password</label>
							<input id="password" name="password" type="password">
						</p>

						<p><input type="submit" id="logIn" value="Log In"></p>

					</form>
				</c:otherwise>
			</c:choose>

		</main>
	</div>
</body>
</html>