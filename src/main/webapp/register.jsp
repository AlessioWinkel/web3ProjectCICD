<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
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

                <form method="POST" action="Controller?command=registerUser" novalidate>

                    <p class="form-group ${firstNameClass}">
                        <label class="control-label" for="firstName">First name</label>
                        <input id="firstName" name="firstName" type="text"
                               value="${firstNamePreviousValue}" >
                    </p>
                    <p class="form-group ${lastNameClass}">
                        <label class="control-label" for="lastName">Last name</label>
                        <input id="lastName" name="lastName" type="text"
                               value="${lastNamePreviousValue}" >
                    </p>

                    <p class="form-group ${emailClass}">
                        <label class="control-label" for="email">Email</label>
                        <input id="email" name="email" type="text"
                               value="${emailPreviousValue}">
                    </p>

                    <p class="form-group ${passwordClass}">
                        <label class="control-label" for="password">Password</label>
                        <input id="password" name="password" type="password"
                               value="${passwordPreviousValue}" >
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
