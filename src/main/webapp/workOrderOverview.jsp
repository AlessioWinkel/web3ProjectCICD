<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 5/12/2022
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Work Order Overview</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<header>
    <h1><span>XXX</span></h1>

    <jsp:include page="nav.jspf"/>
    <h2>
        Work Order Overview
    </h2>

    <c:choose>
        <%-- user is logged in -- show welcome and logout form --%>
    <c:when test="${sessionScope.user!=null}">
    <c:choose>
    <c:when test="${aantalWorkOrders > 0}">
    <c:choose>
    <c:when test="${activated == true}">
    <c:forEach var="workOrder" items="${sortedWorkOrders}">
    <section class="workOrderContainer">

        <p>Order: ${workOrder.workorderid}</p>
        <p>Employee: ${workOrder.username}</p>
        <p>Date: ${workOrder.date}</p>
        <p>Time:${workOrder.start} to ${workOrder.end}</p>
        <p>Duration: ${workOrder.duration} minutes</p>
        <p>Description: ${workOrder.description}</p>
        <a href="Controller?command=editWorkOrderPage&workOrderId=${workOrder.workorderid}">Edit</a>
        <a href="Controller?command=deleteWorkOrderConfirmatie&workOrderId=${workOrder.workorderid}">Remove</a>
    </section>

    </c:forEach>
    </c:when>
    <c:otherwise>

    <c:forEach var="workOrder" items="${workOrders}">
    <section class="workOrderContainer">

        <p>Order: ${workOrder.workorderid}</p>
        <p>Employee: ${workOrder.username}</p>
        <p>Date: ${workOrder.date}</p>
        <p>Time:${workOrder.start} to ${workOrder.end}</p>
        <p>Duration: ${workOrder.duration} minutes</p>
        <p>Description: ${workOrder.description}</p>
        <a href="Controller?command=editWorkOrderPage&workOrderId=${workOrder.workorderid}">Edit</a>
        <a href="Controller?command=deleteWorkOrderConfirmatie&workOrderId=${workOrder.workorderid}">Remove</a>
    </section>

    </c:forEach>

    <form method="POST" action="Controller?command=sortWorkOrdersByDate" novalidate>
        <p><input type="submit" id="searchProject" value="Sort Work Orders By Date"></p>
    </form>
    </c:otherwise>
    </c:choose>

    </c:when>

    <c:otherwise>
    <p>Er zijn nog geen Projects.</p>
    </c:otherwise>
    </c:choose>
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

</body>
</html>
