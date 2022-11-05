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
                    <label class="control-label" for="projectName">Project Name:</label>
                    <a id="projectName" name="projectName">${param.name}</a>
                </p>
                <p class="form-group ${startClass}">
                    <label class="control-label" for="startDate">Start date</label>
                    <input id="startDate" name="startDate" type="date">
                </p>

                <p class="form-group ${eindeClass}">
                    <label class="control-label" for="endDate">End date</label>
                    <input id="endDate" name="endDate" type="date">
                </p>

                <p><input type="submit" id="update" value="Update"></p>

            </form>
    </div>
</main>
</body>
</html>
