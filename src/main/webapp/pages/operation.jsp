<%--
  Created by IntelliJ IDEA.
  User: ААА
  Date: 22.09.2022
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Calculator</h2>

<td>Name:</td>
<td>${sessionScope.user.name}</td>
<s:form action="/calc/operation" method="post" modelAttribute="operation">
    <s:input path="num1" placeholder="Num1"/>
    <br>
    <s:errors path="num1"/>
    <br>
    <s:input path="num2" placeholder="Num2"/>
    <br>
    <s:errors path="num2"/>
    <br>
    <s:input path="operation" placeholder="Operation"/>
    <br>
    <br>
    <s:button>Submit</s:button>
</s:form>

<%--<form action="operation" method="post">--%>
<%--    <input type="text" name="name" placeholder="Name">--%>
<%--    <input type="number" name="num1" placeholder="Num 1">--%>
<%--    <input type="number" name="num2" placeholder="Num 2">--%>
<%--    <input type="text" name="operation" placeholder="Operation">--%>
<%--    <button>Submit</button>--%>
<%--</form>--%>
</body>
</html>
