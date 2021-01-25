<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2020-12-12
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%--在这里引用标准标签库 引入JSTL，对日期进行美化--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>main...........看到我你就成功了！！！</h1>

时间：${mydate}<br><br>
<%--在页面上显示的格式不美观，需要对此格式进行美化，但是使用SimpleDateFormat类不能实现功能，所以要使用JSTL标准标签库，需要添加依赖--%>

美化后的显示
<fmt:formatDate value="${mydate}" pattern="yyyy-MM-dd"></fmt:formatDate><br><br>
</body>
</html>

