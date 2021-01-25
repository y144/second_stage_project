<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2020-11-26
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript">
      function sendAsyncRequest() {
        //1.创建异步对象
          var xmlHttp = new XMLHttpRequest();
        //2.绑定回调事件，就是服务器返回的数据在这里进行处理
          xmlHttp.onreadystatechange = function () {
            alert("readyState:"+xmlHttp.readyState+",status:"+xmlHttp.status)
            //只有当readyState==4 并且 status == 200 说明数据返回正常，可以对数据进行渲染
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
              //服务器端返回的数据在xmlHttp对象的responseText属性中
              document.getElementById("show").innerHTML = xmlHttp.responseText
            }
          };
        //3.初始化异步对象
          xmlHttp.open("get","${pageContext.request.contextPath}/ajax");
        //4.发送请求
        xmlHttp.send();


        //同步请求与异步请求区别
        alert("我说同步请求与异步请求的区别")
      }

    </script>
  </head>
  <body>
  <input type="button" value="发送异步请求" onclick="sendAsyncRequest()"><br><br>
  <div id="show"></div>
  </body>
</html>
