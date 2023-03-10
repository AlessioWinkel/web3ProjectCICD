<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="UTF-8">
<title>Bekijk alle users</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
<header>
<h1><span>XXX</span></h1>

        <jsp:include page="nav.jsp"/>
<h2>
User Overview
</h2>

</header><main>
    <div class="random-tekst"><h2 >Bekijk alle users</h2></div>

    <section class="tabel-box">

        <c:choose>
        <c:when test="${aantalUsers > 0}">

        <table>
            <thead>
            <tr>
                <th>User Id</th>
                <th>Name</th>
                <th>First name</th>
                <th>Email</th>
                <th>Team</th>
                <th>Role</th>
                <th>Pas aan</th>
                <th>Verwijder</th>

            </thead>
            <tbody>
            <c:forEach var="user"  items="${users}">
                <tr>
                    <td>${user.userid}</td>
                    <td>${user.lastName}</td>
                    <td>${user.firstName}</td>
                    <td>${user.email}</td>
                    <td>${user.team}</td>
                    <td>${user.role}</td>
                    <c:choose>
                        <c:when test="${sessionScope.user == null}">

                        </c:when>
                        <c:otherwise>
                            <c:if test="${sessionScope.user.userid == user.userid && sessionScope.user.role == 'EMPLOYEE'}">

                            <td>
                                <a href="Controller?command=editPage&id=${user.userid}&lastName=${user.lastName}&firstName=${user.firstName}&email=${user.email}" id="pasAanKnop">
                                    Pas aan
                                </a>
                            </td>
                            </c:if>
                        </c:otherwise>
                    </c:choose>

                        <c:if test="${sessionScope.user != null && sessionScope.user.role != 'EMPLOYEE' && sessionScope.user.role != 'TEAMLEADER'}">
                            <td>
                                <a href="Controller?command=editPage&id=${user.userid}&lastName=${user.lastName}&firstName=${user.firstName}&email=${user.email}" id="pasAanKnop3">
                                    Pas aan
                                </a>
                            </td>
                            <td>
                                <a href="Controller?command=verwijderConfirmatie&id=${user.userid}&firstName=${user.firstName}" id="verwijderKnop2">X</a>
                            </td>
                        </c:if>

                    <c:if test="${sessionScope.user != null && sessionScope.user.role == 'TEAMLEADER' && user.team == sessionScope.user.team}">
                        <td>
                            <a href="Controller?command=editPage&id=${user.userid}&lastName=${user.lastName}&firstName=${user.firstName}&email=${user.email}" id="pasAanKnop2" class="verwijderKnop">
                                Pas aan
                            </a>
                        </td>
                    </c:if>
                </tr>

            </c:forEach>
            </tbody>
            <caption>Users Overview</caption>
        </table>
        </c:when>
        <c:otherwise>
        <p>Er zijn nog geen Users.</p>
        </c:otherwise>
        </c:choose>


</main>
<footer>
&copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</div>
</body>
</html>