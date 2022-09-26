<%--
  Created by IntelliJ IDEA.
  User: ААА
  Date: 22.09.2022
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<%--<h1>Calculator ${num1} ${num2} ${operation} ${calculate}</h1>--%>
<form action="/calc/operation" method ="post">
    <input type="number" name="num1" placeholder="Num3">
    <input type="number" name="num2" placeholder="Num2">
    <input type="text" name="operation" placeholder="Operation">
    <button>Submit</button>
</form>
<p>${result}</p>
</body>
</html>
