<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
    <h1><span>Work Order overview</span></h1>

    <jsp:include page="nav.jsp"/>
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
        <c:if test="${sessionScope.user.team == workOrder.team && sessionScope.user.role == 'EMPLOYEE'}">
            <p>Order: ${fn:escapeXml(workOrder.workorderid)}</p>
            <p>Employee: ${fn:escapeXml(workOrder.username)}</p>
            <p>Date: ${fn:escapeXml(workOrder.date)}</p>
            <p>Time:${fn:escapeXml(workOrder.start)} to ${fn:escapeXml(workOrder.end)}</p>
            <p>Duration: ${fn:escapeXml(workOrder.duration)} minutes</p>
            <p>Description: ${fn:escapeXml(workOrder.description)}</p>
            <a href="Controller?command=editWorkOrderPage&workOrderId=${fn:escapeXml(workOrder.workorderid)}">Edit</a>
        </c:if>

        <c:if test="${sessionScope.user.role == 'TEAMLEADER' && sessionScope.user.team == workOrder.team}">
            <p>Order: ${fn:escapeXml(workOrder.workorderid)}</p>
            <p>Employee: ${fn:escapeXml(workOrder.username)}</p>
            <p>Date: ${fn:escapeXml(workOrder.date)}</p>
            <p>Time:${fn:escapeXml(workOrder.start)} to ${fn:escapeXml(workOrder.end)}</p>
            <p>Duration: ${fn:escapeXml(workOrder.duration)} minutes</p>
            <p>Description: ${fn:escapeXml(workOrder.description)}</p>
            <a href="Controller?command=editWorkOrderPage&workOrderId=${fn:escapeXml(workOrder.workorderid)}">Edit</a>
        </c:if>

        <c:if test="${sessionScope.user.role == 'DIRECTOR'}">
            <p>Order: ${fn:escapeXml(workOrder.workorderid)}</p>
            <p>Employee: ${fn:escapeXml(workOrder.username)}</p>
            <p>Date: ${fn:escapeXml(workOrder.date)}</p>
            <p>Time:${fn:escapeXml(workOrder.start)} to ${fn:escapeXml(workOrder.end)}</p>
            <p>Duration: ${fn:escapeXml(workOrder.duration)} minutes</p>
            <p>Description: ${fn:escapeXml(workOrder.description)}</p>
            <a href="Controller?command=editWorkOrderPage&workOrderId=${fn:escapeXml(workOrder.workorderid)}">Edit</a>
            <a href="Controller?command=deleteWorkOrderConfirmatie&workOrderId=${fn:escapeXml(workOrder.workorderid)}">Remove</a>
        </c:if>
    </section>

    </c:forEach>
    </c:when>
    <c:otherwise>

    <c:forEach var="workOrder" items="${workOrders}">
    <section class="workOrderContainer">

        <c:if test="${sessionScope.user.team == workOrder.team && sessionScope.user.role == 'EMPLOYEE'}">
            <p>Order: ${fn:escapeXml(workOrder.workorderid)}</p>
            <p>Employee: ${fn:escapeXml(workOrder.username)}</p>
            <p>Date: ${fn:escapeXml(workOrder.date)}</p>
            <p>Time:${fn:escapeXml(workOrder.start)} to ${fn:escapeXml(workOrder.end)}</p>
            <p>Duration: ${fn:escapeXml(workOrder.duration)} minutes</p>
            <p>Description: ${fn:escapeXml(workOrder.description)}</p>
            <a href="Controller?command=editWorkOrderPage&workOrderId=${fn:escapeXml(workOrder.workorderid)}">Edit</a>
        </c:if>

        <c:if test="${sessionScope.user.role == 'TEAMLEADER' && sessionScope.user.team == workOrder.team}">
            <p>Order: ${fn:escapeXml(workOrder.workorderid)}</p>
            <p>Employee: ${fn:escapeXml(workOrder.username)}</p>
            <p>Date: ${fn:escapeXml(workOrder.date)}</p>
            <p>Time:${fn:escapeXml(workOrder.start)} to ${fn:escapeXml(workOrder.end)}</p>
            <p>Duration: ${fn:escapeXml(workOrder.duration)} minutes</p>
            <p>Description: ${fn:escapeXml(workOrder.description)}</p>
            <a href="Controller?command=editWorkOrderPage&workOrderId=${fn:escapeXml(workOrder.workorderid)}">Edit</a>
        </c:if>

        <c:if test="${sessionScope.user.role == 'DIRECTOR'}">
            <p>Order: ${fn:escapeXml(workOrder.workorderid)}</p>
            <p>Employee: ${fn:escapeXml(workOrder.username)}</p>
            <p>Date: ${fn:escapeXml(workOrder.date)}</p>
            <p>Time:${fn:escapeXml(workOrder.start)} to ${fn:escapeXml(workOrder.end)}</p>
            <p>Duration: ${fn:escapeXml(workOrder.duration)} minutes</p>
            <p>Description: ${fn:escapeXml(workOrder.description)}</p>
            <a href="Controller?command=editWorkOrderPage&workOrderId=${fn:escapeXml(workOrder.workorderid)}">Edit</a>
            <a href="Controller?command=deleteWorkOrderConfirmatie&workOrderId=${fn:escapeXml(workOrder.workorderid)}">Remove</a>
        </c:if>
    </section>

    </c:forEach>

    <form method="POST" action="Controller?command=sortWorkOrdersByDate" novalidate>
        <p><input type="submit" id="sortWorkOrders" value="Sort Work Orders By Date"></p>
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
    <p>U heeft geen rechten om deze site te bezoeken</p>

    <p>Please log in.</p>
    <form method="POST" action="Controller?command=LogIn" novalidate>

        <p class="form-group">
            <label class="control-label" for="email">Email</label>
            <input id="email" name="email" type="text" value="${fn:escapeXml(param.email)}">
        </p>
        <p class="form-group">
            <label class="control-label" for="password">Password</label>
            <input id="password" name="password" type="password" value="${fn:escapeXml(param.password)}">
        </p>

        <p><input type="submit" id="logIn" value="Log In"></p>

    </form>
    </c:otherwise>
    </c:choose>

</body>
</html>
