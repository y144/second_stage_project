<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2020-12-12
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/one/requestTransmitPage.action">1.请求转发跳转页面</a><br><br>
<a href="${pageContext.request.contextPath}/one/requestTransmitAction.action">2.请求转发跳转Action</a><br><br>
<a href="${pageContext.request.contextPath}/one/againGuidePage.action">3.重定向跳转页面</a><br><br>
<a href="${pageContext.request.contextPath}/one/againGuideAction.action">4.重定向跳转Action</a><br>

<br><br><br>
<h2>日期的处理</h2>
<form action="${pageContext.request.contextPath}/three/showDate.action">
日期：<input type="date" name="mydate"><br>
<input type="submit" value="提交"><br>
</form>
</body>
</html>
