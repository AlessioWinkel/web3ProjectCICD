<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 24/10/2022
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<body>
<div id="container">
    <header>
        <h1><span>Add a project</span></h1>
        <jsp:include page="nav.jsp"/>
        <h2>
            Register
        </h2>

    </header>
    <main>
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

        <div id="container2">
            <main>
                <c:if test="${not empty errors}">
                <div class="alert alert-danger">
                    <ul>
                        <c:forEach items="${errors}" var="error">
                            <li>${error}</li>
                        </c:forEach>
                    </ul>
                </div>
                </c:if>
                <h2>Registreer je</h2>

                <form method="POST" action="Controller?command=addProject" novalidate>

                    <p class="form-group ${projectNameClass}">
                        <label class="control-label" for="projectNaam">Project name *</label>
                        <input id="projectNaam" name="projectNaam" type="text"
                               value="${projectNaamPreviousValue}">
                    </p>
                    <p>
                        <label for="team">Team</label>
                        <c:if test="${sessionScope.user.role == 'TEAMLEADER'}">
                            <select name="team" id="team">
                                <option value="${sessionScope.user.team}">${sessionScope.user.team}</option>
                            </select>
                        </c:if>

                        <c:if test="${sessionScope.user.role == 'DIRECTOR'}">

                        <select name="team" id="team">
                            <option value="Alpha">Alpha</option>
                            <option value="Beta">Beta</option>
                            <option value="Gamma">Gamma</option>
                            <option value="Delta">Delta</option>
                            <option value="Epsilon">Epsilon</option>
                        </select>
                    </p>
                        </c:if>


                    <p class="form-group ${startClass}">
                        <label class="control-label" for="start">Start datum *</label>
                        <input id="start" name="start" type="date"
                               value="${startPreviousValue}">
                        <input id="startTime" name="startTime" type="time"
                               value="${startTimePreviousValue}">
                    </p>

                    <p class="form-group ${eindeClass}">
                        <label class="control-label" for="einde">Eind datum</label>
                        <input id="einde" name="einde" type="date"
                               value="${eindePreviousValue}">
                        <input id="eindeTime" name="eindeTime" type="time"
                               value="${eindeTimePreviousValue}">
                    </p>

                    <p><input type="submit" id="signUp" value="Sign Up"></p>
                </form>
        </div>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</c:if>
</body>
</html>
