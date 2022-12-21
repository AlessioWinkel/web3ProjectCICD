<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 25/10/2022
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit project</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<main>
    <header>
        <jsp:include page="nav.jspf"/>
    </header>

    <div id="container2">
        <main>
            <h1>Edit Project</h1>
            <h2>Project id: ${param.id}</h2>
            <c:if test="${not empty errors}">
            <div class="alert alert-danger">
                <ul>
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
            </c:if>

            <form method="POST" action="Controller?command=editProject&id=${param.id}" novalidate>

                <p class="form-group ${projectNameClass}">
                    <label class="control-label" for="projectName">Project Name *</label>
                    <a id="projectName" name="projectName">${param.name}</a>
                </p>
                <p class="form-group ${startClass}">
                    <label class="control-label" for="start">Start datum *</label>
                    <input id="start" name="start" type="date"
                           value="${startPreviousValue}">
                    <input id="startTime" name="startTime" type="time"
                           value="${startTimePreviousValue}" >
                </p>

                <p class="form-group ${eindeClass}">
                    <label class="control-label" for="einde">Eind datum</label>
                    <input id="einde" name="einde" type="date"
                           value="${eindePreviousValue}" >
                    <input id="eindeTime" name="eindeTime" type="time"
                           value="${eindeTimePreviousValue}" >
                </p>

                <p><input type="submit" id="update" value="Update"></p>

            </form>
    </div>
</main>
</body>
</html>
