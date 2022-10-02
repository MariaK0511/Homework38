<%--
  Created by IntelliJ IDEA.
  User: ААА
  Date: 22.09.2022
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>User Information</title>
</head>
<body>
<h2>User information</h2>

<table>
    <tr>
        <td>Name:</td>
        <td>${sessionScope.user.name}</td>
        <br>
        <td>${userOperationHistory}</td>
    </tr>
</table>

</body>
</html>
