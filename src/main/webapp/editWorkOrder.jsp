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
    <jsp:include page="nav.jspf"/>
</header>
<body>

<h2>Edit work order </h2>



<form method="POST" action="Controller?command=editWorkOrder" novalidate>

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
</body>
</html>
