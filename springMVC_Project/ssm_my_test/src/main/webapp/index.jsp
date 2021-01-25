<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2020-12-13
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="account/findAll">测试</a>

<h2>测试保存</h2>
<form action="account/save" method="post">
    姓名：<input type="text" name="name"><br>
    年龄：<input type="text" name="age"><br>
    邮箱：<input type="text" name="email"><br>
    <input type="submit" value="保存学生信息">
</form>
</body>
</html>
