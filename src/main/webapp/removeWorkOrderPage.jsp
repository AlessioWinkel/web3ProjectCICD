<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 21/12/2022
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove Work Order</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<c:if test="${sessionScope.user == null}">
    <p>U heeft geen rechten om deze site te bezoeken</p>
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
</c:if>
<c:if test="${sessionScope.user != null}">

<p>Bent u zeker dat u deze workorder wilt verwijderen?</p>
<a href="Controller?command=deleteWorkOrder&workOrderId=${param.workOrderId}">Ja</a>
<a href="Controller?command=workOrderOverviewPage">Nee</a>
</c:if>
</body>
</html>
