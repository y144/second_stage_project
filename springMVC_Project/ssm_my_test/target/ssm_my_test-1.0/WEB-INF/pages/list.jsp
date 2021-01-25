<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2020-12-13
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>查询了所有的学生的信息</h2>

<c:forEach items="${list}" var="student">
    ${student.id}<br><br>
    ${student.name}<br><br>
    ${student.age}<br><br>
    ${student.email}<br><br>
</c:forEach>
</body>
</html>
