<%--
  Created by IntelliJ IDEA.
  User: landrymuluisha
  Date: 20/12/2022
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Course overview </title>
</head>
<body>
    <header>
        <h1><span>XXX</span></h1>

        <jsp:include page="nav.jspf"/>
        <h2>
            Course Overview
        </h2>
    </header>
    <main>
        <div class="random-tekst"><h2 >PBA TI</h2></div>
        <c:choose>
            <c:when test="${aantalCourses > 0}">

        <table>
            <thead>
            <th>Name</th>
            <th>Lectors</th>
            </thead>

            <tbody>

            <c:forEach var="course" items="=${courses}">
                <tr>
                    <td>${course.name}</td>
                    <td>${course.lector}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        </c:when>
        <c:otherwise>
            <p>Er zijn nog geen Courses.</p>
        </c:otherwise>
        </c:choose>

    </main>
</body>
</html>
