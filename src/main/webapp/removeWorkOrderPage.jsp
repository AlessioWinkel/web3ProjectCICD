<%--
  Created by IntelliJ IDEA.
  User: aless
  Date: 21/12/2022
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Bent u zeker dat u deze workorder wilt verwijderen?</p>
<a href="Controller?command=deleteWorkOrder&workOrderId=${param.workOrderId}">Ja</a>
<a href="Controller?command=workOrderOverviewPage">Nee</a>

</body>
</html>
