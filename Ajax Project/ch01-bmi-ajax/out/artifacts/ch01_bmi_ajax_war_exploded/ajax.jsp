<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2020-11-26
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="WEB-INF/js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        function fun() {
            //准备要提交的数据
            var name = $("#name").val();
            var weight = $("#weight").val();
            var height = $("#height").val();
            //使用json对象发送请求
            $.ajax({
                //规定发送请求的url
                url:"${pageContext.request.contextPath}/bim",
                //规定发送请求的请求方式
                type:"get",
                //规定要发送到服务器的数据  “name”是Servlet中将要取得的参数名称，
                // name是在页面中读取到的数据，就是要提交的数据
                data:{"name":name,"weight":weight,"height":height},
                //期望从服务器响应的数据类型
                dataType:"text",
                //当请求成功时运行的函数
                success:function (data) {
                    $("#result").html(data)
                }
            });

        }
    </script>
</head>
<body>
<form>
    <h2>计算BMI</h2>
    <br><br>
    <p>姓名：<input type="text" name="name" id="name"></p>
    <p>体重：<input type="text" name="weight" id="weight"></p>
    <p>身高：<input type="text" name="height" id="height"></p>
    <p><input type="button" value="计算" onclick="fun()" ></p>
    <br><br>
    <div id="result"></div>
</form>
</body>
</body>
</html>
