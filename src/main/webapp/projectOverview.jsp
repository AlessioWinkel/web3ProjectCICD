<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 24/10/2022
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<head>
    <title>Bekijk alle projecten</title>
</head>
<body>
<div id="container">
    <header>
        <h1><span>XXX</span></h1>

        <jsp:include page="nav.jspf"/>
        <h2>
            Project Overview
        </h2>

    </header><main>
    <div class="random-tekst"><h2 >Bekijk alle Projecten</h2></div>

    <section class="tabel-box">

        <c:choose>
        <c:when test="${aantalProjecten > 0}">

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


</main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
