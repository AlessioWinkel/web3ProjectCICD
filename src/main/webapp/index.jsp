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
			<h1>User overview</h1>
			<table>
				<tr>
					<th>User id</th>
					<th>Name</th>
					<th>Firstname</th>
					<th>Email</th>
					<th>Team</th>
					<th>Role</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</table>
		</main>
	</div>
</body>
</html>