<%--
  Created by IntelliJ IDEA.
  User: ААА
  Date: 26.09.2022
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Registration</title>
</head>

<body>
<h2>Registration</h2>
<s:form action="/calc/reg" method="post" modelAttribute="user">
	<s:input path="name" placeholder="Name"/>
	<br>
	<s:errors path="name"/>
	<br>
	<s:input path="surname" placeholder="Username"/>
	<br>
	<s:errors path="surname"/>
	<br>
	<s:input path="password" placeholder="Password"/>
	<br>
	<s:errors path="password"/>
	<br>
	<s:button>Submit</s:button>
</s:form>



<%--<form action="/calc/reg" method="post">--%>
<%--	<input type="text" name="name" placeholder="Name">--%>
<%--	<input type="text" name="surname" placeholder="Surname">--%>
<%--	<input type="text" name="password" placeholder="Password">--%>
<%--	<button>Submit</button>--%>
<%--</form>--%>
<%--<p>${user}</p>--%>
</body>
</html>
