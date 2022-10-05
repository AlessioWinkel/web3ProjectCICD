<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 5/10/2022
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<main>
    <header>
        <jsp:include page="nav.jspf"/>
    </header>

    <div id="container2">
        <main>
            <h1>Edit user</h1>
            <h2>User id: ${user.userid}</h2>
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

            <form method="POST" action="Controller?command=updateUser&id=${user.userid}" novalidate>

                <p class="form-group ${firstNameClass}">
                    <label class="control-label" for="firstName">First name</label>
                    <input id="firstName" name="firstName" type="text"
                           value="${param.firstName}" >
                </p>
                <p class="form-group ${lastNameClass}">
                    <label class="control-label" for="lastName">Last name</label>
                    <input id="lastName" name="lastName" type="text"
                           value="${param.lastName}" >
                </p>

                <p class="form-group ${emailClass}">
                    <label class="control-label" for="email">Email</label>
                    <input id="email" name="email" type="text"
                           value="${param.email}">
                </p>

                <p>
                    <label for="role">Team</label>

                    <select name="role" id="role">
                        <option value="Employee">Employee</option>
                        <option value="Director">Director</option>
                        <option value="Teamleader">Teamleader</option>
                    </select>
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
                <p><input type="submit" id="update" value="Update"></p>
            </form>
    </div>
</main>

</body>
</html>
