<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 5/12/2022
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body><c:choose>

    <%-- user is logged in -- show welcome and logout form --%>
    <c:when test="${sessionScope.user!=null}">
        <c:if test="${not empty errors}">
            <div class="alert alert-danger">
                <ul>
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <h2>Voeg work order toe</h2>


        <form method="POST" action="Controller?command=addWorkOrder" novalidate>

            <p class="form-group ${dateClass}">
                <label class="control-label" for="date">Date *</label>
                <input id="date" name="date" type="date"
                       value="${datePreviousValue}" >
                <input id="dateTime" name="dateTime" type="time"
                       value="${dateTimePreviousValue}" >
            </p>
            <p class="form-group ${startTimeClass}">
                <label class="control-label" for="startTime">Start Time *</label>
                <input id="startTime" name="startTime" type="time"
                       value="${startTimePreviousValue}" >
            </p>

            <p class="form-group ${endTimeClass}">
                <label class="control-label" for="endTime">End Time *</label>
                <input id="endTime" name="endTime" type="time"
                       value="${endTimePreviousValue}">
            </p>

            <p class="form-group ${descriptionClass}">
                <label class="control-label" for="description">Description *</label>
                <textarea id="description" name="description" rows="4" cols="50"
                          value="${descriptionPreviousValue}"></textarea>
            </p>

            <p><input type="submit" id="addWorkOrder" value="Add Work Order"></p>
        </form>
    </c:when>
    <c:otherwise>
        <%-- no user is logged in --%>
        <p>Please log in to add and view work orders</p>

    </c:otherwise>
</c:choose>



</body>
</html>
