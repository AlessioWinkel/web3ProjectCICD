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

                <table>
                    <thead>
                    <tr>
                        <th>Project Id</th>
                        <th>Name</th>
                        <th>Team</th>
                        <th>Start</th>
                        <th>End</th>
                        <th>Pas aan</th>
                        <th>Verwijder</th>

                    </thead>
                    <tbody>
                    <c:forEach var="project"  items="${projects}">
                        <tr>
                            <td>${project.projectid}</td>
                            <td>${project.name}</td>
                            <td>${project.team}</td>
                            <td>${project.start}</td>
                            <td>${project.end}</td>

                            <td>
                                <a href="Controller?command=editProjectPage&id=${project.projectid}&name=${project.name}&start=${project.start}&einde=${project.end}" id="pasAanKnop">
                                    Pas aan
                                </a>
                            </td>

                            <td>
                                <a href="Controller?command=verwijderConfirmatieProject&id=${project.projectid}&projectNaam=${project.name}&start=" id="verwijderKnop">X</a>
                            </td>
                        </tr>

                    </c:forEach>
                    </tbody>
                    <caption>Projects Overview</caption>
                </table>
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
