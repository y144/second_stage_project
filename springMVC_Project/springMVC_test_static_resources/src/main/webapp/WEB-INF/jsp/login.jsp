<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2020-12-14
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/one/login" method="post">
    用户名：<input name="myname"><br>
    密码：<input name="password"><br>
    <input type="submit" value="登录">
</form>
<br>${msg}
</body>
</html>
