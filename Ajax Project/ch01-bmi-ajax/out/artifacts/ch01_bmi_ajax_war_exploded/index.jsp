<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2020-11-26
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
      <script type="text/javascript">
          function fun() {//页面要放在一起
              //1.在发送请求时要提交姓名、身高、体重的数据，所有需要先取得数据
              var name =  document.getElementById("name").value;
              var weight = document.getElementById("weight").value;
              var height = document.getElementById("height").value;


              //2.进行异步的数据的提交处理
              //1).创建异步对象
              var xmlHttp = new XMLHttpRequest()
              //2).绑定onreadystatechange 时间
              xmlHttp.onreadystatechange = function () {
                  if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
                      //说明请求响应正常，可以取数据了
                      var date = xmlHttp.responseText;
                      //在页面上弹出响应的数据
                      alert(date);
                      //将数据渲染到页面指定元素上，注意观察页面的局部刷新
                      document.getElementById("result").innerHTML = date;
                  }
              };
              //因为要提交数据，所以要先进行数据的封装(这里的数据=两边是不能有空格的)
              var param = "?name="+name+"&weight="+weight+"&height="+height;
              //3).初始化请求
              xmlHttp.open("get","${pageContext.request.contextPath}/bmi"+param);
              //4).发送请求
              xmlHttp.send();


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
</html>
