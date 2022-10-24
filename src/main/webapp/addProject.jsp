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
<body>
<div id="container">
    <header>
        <h1><span>XXX</span></h1>
        <jsp:include page="nav.jspf"/>
        <h2>
            Register
        </h2>

    </header><main>


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
                    <label class="control-label" for="projectNaam">Project name</label>
                    <input id="projectNaam" name="projectNaam" type="text"
                           value="${projectNaamPreviousValue}" >
                </p>
                <p>
                    <label for="team">Team</label>

                    <select name="team" id="team">
                        <option value="Alpha">Alpha</option>
                        <option value="Beta">Beta</option>
                        <option value="Gamma">Gamma</option>
                        <option value="Delta">Delta</option>
                        <option value="Epsilon">Epsilon</option>
                    </select>
                </p>

                <p class="form-group ${startClass}">
                    <label class="control-label" for="start">Start datum "yyyy-MM-dd" formaat</label>
                    <input id="start" name="start" type="text"
                           value="${startPreviousValue}">
                </p>

                <p class="form-group ${eindeClass}">
                    <label class="control-label" for="einde">Eind datum "yyyy-MM-dd" formaat</label>
                    <input id="einde" name="einde" type="text"
                           value="${eindePreviousValue}" >
                </p>

                <p><input type="submit" id="signUp" value="Sign Up"></p>
            </form>
    </div>
</main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
