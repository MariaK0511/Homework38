<%--
  Created by IntelliJ IDEA.
  User: ААА
  Date: 26.09.2022
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>

<body>
<h2>Registration</h2>
<form action="/calc/reg" method="post">
	<input type="text" name="name" placeholder="Name">
	<input type="text" name="surname" placeholder="Surname">
	<input type="text" name="password" placeholder="Password">
	<button>Submit</button>
</form>
<p>${user}</p>
</body>
</html>
