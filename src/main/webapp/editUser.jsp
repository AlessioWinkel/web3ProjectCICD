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
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<main>
    <header>
        <jsp:include page="nav.jsp"/>
    </header>

    <c:if test="${sessionScope.user == null}">
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
            <h1>Edit user</h1>
            <h2>User id: <a id="userIdElement">${param.id}</a></h2>
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

            <form method="POST" action="Controller?command=updateUser&id=${param.id}&email=${param.email}" novalidate>

                <p class="form-group ${firstNameClass}">
                    <label class="control-label" for="firstNameInput">First name</label>
                    <input id="firstNameInput" name="firstNameInput" type="text"
                           value="${param.firstName}">
                </p>
                <p class="form-group ${lastNameClass}">
                    <label class="control-label" for="lastNameInput">Last name</label>
                    <input id="lastNameInput" name="lastNameInput" type="text"
                           value="${param.lastName}">
                </p>

                <p class="form-group ${emailClass}">
                    <label class="control-label" for="emailInput">Email</label>
                    <input id="emailInput" name="emailInput" type="text"
                           value="${param.email}">
                </p>

                <p>
                    <label for="roleInput">Role</label>

                    <select name="roleInput" id="roleInput">
                        <c:if test="${sessionScope.user.userid == param.id && sessionScope.user.role == 'TEAMLEADER'}">
                            <option value="Teamleader">Teamleader</option>

                        </c:if>

                        <c:if test="${sessionScope.user.userid != param.id && sessionScope.user.role == 'TEAMLEADER'}">
                            <option value="Teamleader">Teamleader</option>
                            <option value="Employee">Employee</option>
                        </c:if>


                        <c:if test="${sessionScope.user.userid == param.id && sessionScope.user.role == 'EMPLOYEE'}">
                            <option value="Employee">Employee</option>
                        </c:if>
                        <c:if test="${sessionScope.user.role == 'DIRECTOR'}">
                            <option value="Director">Director</option>
                            <option value="Teamleader">Teamleader</option>
                            <option value="Employee">Employee</option>
                        </c:if>

                        <c:if test="${sessionScope.user.role == 'DIRECTOR' && sessionScope.user.userid == param.id}">
                            <option value="Director">Director</option>
                        </c:if>
                    </select>
                </p>
                <p>
                    <label for="teamInput">Team</label>

                    <c:if test="${sessionScope.user.role != 'DIRECTOR'}">
                        <select name="teamInput" id="teamInput">
                            <option value="${sessionScope.user.team}">${sessionScope.user.team}</option>
                        </select>
                    </c:if>

                    <c:if test="${sessionScope.user.role == 'DIRECTOR' && sessionScope.user.userid != param.id}">
                        <select name="teamInput" id="teamInput">
                            <option value="Alpha">Alpha</option>
                            <option value="Beta">Beta</option>
                            <option value="Gamma">Gamma</option>
                            <option value="Delta">Delta</option>
                            <option value="Epsilon">Epsilon</option>
                        </select>
                    </c:if>

                    <c:if test="${sessionScope.user.role == 'DIRECTOR' && sessionScope.user.userid == param.id}">
                        <select name="teamInput" id="teamInput">
                            <option value="Alpha">Alpha</option>
                        </select>
                    </c:if>

                </p>
                <p><input type="submit" id="update" value="Update"></p>
            </form>
    </div>
</main>
</c:if>
</body>
</html>
