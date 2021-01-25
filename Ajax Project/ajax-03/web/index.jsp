<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2020-11-27
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--导入这个函数库后，在当前的页面上就可以使用标准标签库来干活，页面渲染的工作就可以在页面上进行-->
<html>
  <head>
    <title>$Title$</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
      function fun1() {
        $.ajax({
          url:"${pageContext.request.contextPath}/one",
          type:"post",
          dataType:"json",
          success:function (data) {
            //将json文本转换为json对象,eval() 调用 JavaScript 编译器，既然JSON是 JavaScript 的真子集，编译器将正确分析文本和产生对象结构，必须把文本包围在括号中，eval() 能编译和执行任何的JavaScript程序，因此可能有安全问题
            var myObject = eval("("+data+")");
            $("#showOne").html("姓名:"+data.name+"---年龄:"+data.age+"---性别:"+data.sex)
          }
        });
      }
      
      function fun2() {
        $.ajax({
          url:"${pageContext.request.contextPath}/two",
          type:"post",
          dataType:"json",
          success:function(data){
            var tou = "<table border=\"1\">\n"+
                    "<tr>\n" +
                    "<th>姓名</th>\n"+
                    "<th>年龄</th>\n"+
                    "<th>性别</th>\n"+
                    "</tr>";
                      var middle = "";
                    for(var i=0;i<data.length;i++) {
                      var stu = data[i];
                      middle += "<tr>\n"+
                      "<th>"+stu.name+"</th>\n"+
                      "<th>"+stu.age+"</th>\n"+
                      "<th>"+stu.sex+"</th>\n"+
                    "</tr>";
                    }
            var wei ="</table>";
            $("#showList").html(tou+middle+wei)
          }

        });
      }

      function fun3(){
        $.ajax({
          url:"${pageContext.request.contextPath}/you",
          success:function () {
            //在执行完这个异步请求之后回来，在定位这个表格标签，使他重新加载，定位这个div
            $("#showYou").load("http://localhost:8080/index.jsp #showYou")
          }
        });
      }
    </script>

  </head>
  <body>
  <a href="javascript:fun1()">返回一个学生</a><br><br>
  <a href="javascript:fun2()">返回一个学生列表</a><br><br>
  <a href="javascript:fun3()">返回一个学生列表优化</a><br><br>
  <div id="showOne"></div>
  <div id="showList"></div>
  <div id="showYou">
  <!--使用JSTL（forEach循环）循环，直接在页面上进行，items是必须得在Servlet里面放在当前Session里面，或者request对象中，就是把那个需要遍历的集合放在Session中或者request中-->
  <table border="1">
    <tr>
      <th>姓名</th>
      <th>年龄</th>
      <th>性别</th>
    </tr>
    <!--items= 直接取出这个集合，，在items里面通过EL表达式可以吧Session或者request的对象中的list取出来，取出来的值就是var,也就是一个临时对象-->
    <c:forEach items="${list}" var="stu">
      <tr>
        <td>${stu.name}</td>
        <td>${stu.age}</td>
        <td>${stu.sex}</td>
      </tr>
    </c:forEach>
  </table>
  </div>
  </body>

</html>
