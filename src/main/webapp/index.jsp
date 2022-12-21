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
				<c:when test="${not empty user}">

					<p>Welcome, ${user.firstName }</p>
					<form action="Controller?command=LogOut" method="POST">
						<input type="submit" id="LogOut" value="Log Out">
					</form>

					<c:if test="${not empty errors}">
						<div class="alert alert-danger">
							<ul>
								<c:forEach items="${errors}" var="error">
									<li>${error}</li>
								</c:forEach>
							</ul>
						</div>
					</c:if>

					<form method="POST" action="Controller?command=searchProjectById" novalidate>

						<p class="form-group ${projectIdClass}">
							<label class="control-label" for="projectIdInput">Project Id</label>
							<input id="projectIdInput" name="projectId" type="text">
						</p>


						<p><input type="submit" id="searchProject" value="Search Project"></p>
					</form>


				<%-- user is logged in -- show welcome and logout form --%>

					<c:choose>
						<c:when test="${not empty project}">
						<p>Jouw gezochte project:</p>
						<tr>
							<td>${project.projectid}</td>
							<td>${project.name}</td>
							<td>${project.team}</td>
							<td>${project.start}</td>
							<td>${project.end}</td>

						</tr>
						</c:when>
						<c:otherwise>
							<p>Er is nog geen project gezocht</p>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:if test="${not empty fout}">
						<div class="alert alert-danger">
							<ul>
									<li>${fout}</li>
							</ul>
						</div>
					</c:if>
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