<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 24/10/2022
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove Project</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<header>
    <jsp:include page="nav.jsp"/>
</header>
<body>

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

<c:if test="${sessionScope.user != null}">

<article class="random-tekst">
    <p>Bent u zeker dat u het project wilt verwijderen?</p>
    <a href="Controller?command=verwijderProject&id=${param.id}" id="verwijderConfirmatie">
        Ja
    </a>
    <p>
        <a href="Controller?command=projectOverview" id="verwijderCancel">Cancel</a>
    </p>

</article>
</c:if>

</body>
</html>
