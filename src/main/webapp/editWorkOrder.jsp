<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 7/12/2022
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit work order page</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<header>
    <jsp:include page="nav.jsp"/>
</header>
<body>

<h2>Edit work order </h2>

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

<c:if test="${sessionScope.user!=null}">

<form method="POST" action="Controller?command=editWorkOrder&workOrderId=${param.workOrderId}" novalidate>
    <c:if test="${not empty errors}">
        <div class="alert alert-danger">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>

    <p class="form-group ${dateClass}">
        <label class="control-label" for="date">Date </label>
        <input id="date" name="date" type="date"
               value="${datePreviousValue}" >
        <input id="dateTime" name="dateTime" type="time"
               value="${dateTimePreviousValue}" >
    </p>
    <p class="form-group ${startTimeClass}">
        <label class="control-label" for="startTime">Start Time </label>
        <input id="startTime" name="startTime" type="time"
               value="${startTimePreviousValue}" >
    </p>

    <p class="form-group ${endTimeClass}">
        <label class="control-label" for="endTime">End Time </label>
        <input id="endTime" name="endTime" type="time"
               value="${endTimePreviousValue}">
    </p>

    <p class="form-group ${descriptionClass}">
        <label class="control-label" for="description">Description </label>
        <textarea id="description" name="description" rows="4" cols="50"
                  value="${descriptionPreviousValue}"></textarea>
    </p>

    <p><input type="submit" id="editWorkOrder" value="Update Work Order"></p>
</form>
</c:if>
</body>
</html>
