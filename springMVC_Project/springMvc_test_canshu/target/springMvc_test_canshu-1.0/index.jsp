<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2020-12-12
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>1.单个数据散提交</h2>
<form action="${pageContext.request.contextPath}/one/danGe.action" method="post">
    姓名：<input name="uname"><br>
    年龄：<input name="age"><br>
    <input type="submit" value="提交">
</form>

<h2>2.对象数据提交</h2>
<form action="${pageContext.request.contextPath}/one/object.action">
    姓名：<input name="uname"><br>
    年龄：<input name="age"><br>
    <input type="submit" value="提交">
</form>

<h2>3.表单元素的name属性与action中的方法参数名称不一致</h2>
<form action="${pageContext.request.contextPath}/one/three.action">
    姓名：<input name="myname"><br>
    年龄：<input name="myage"><br>
    <input type="submit" value="提交">
</form>

<h2>4.在地址栏或超链接进行数据提交</h2>
<a href="${pageContext.request.contextPath}/one/four/中国法规/4323/spring.action">提交数据到action</a>
</body>

<h2>5.手工读取数据</h2>
<form action="${pageContext.request.contextPath}/one/five.action">
    姓名：<input name="uname">
    年龄：<input name="age">
    <input type="submit" value="提交">
</form>
</html>
