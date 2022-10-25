<%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 5/10/2022
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verwijder Confirmatie</title>
    <link rel="stylesheet" href="styles/style.css" type="text/css">
</head>
<header>
    <jsp:include page="nav.jspf"/>
</header>
<body>
<article class="random-tekst">
    <p>Bent u zeker dat u de afspraak wilt verwijderen?</p>
    <a href="Controller?command=verwijder&id=${param.id}" id="verwijderConfirmatie">
        Ja
    </a>
    <p>
        <a href="Controller?command=userOverview" id="verwijderCancel">Cancel</a>
    </p>

</article>

</body>
</html>
