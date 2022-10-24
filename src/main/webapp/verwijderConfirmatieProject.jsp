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
    <title>Title</title>
</head>
<header>
    <jsp:include page="nav.jspf"/>
</header>
<body>
<article class="random-tekst">
    <p>Bent u zeker dat u het project wilt verwijderen?</p>
    <a href="Controller?command=verwijderProject&id=${param.id}&naam=${param.name}" id="verwijderConfirmatie">
        Ja
    </a>
    <p>
        <a href="Controller?command=projectOverview" id="verwijderCancel">Cancel</a>
    </p>

</article>

</body>
</html>
