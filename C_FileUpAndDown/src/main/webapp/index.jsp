<%--
  Created by IntelliJ IDEA.
  User: haogu
  Date: 2022/7/12
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/uploads.do" enctype="multipart/form-data"  method="post">
      上传用户：<input type="text" name="username"><br/>
      <P><input type="file" name="file1"></P>
      <P><input type="file" name="file1"></P>
      <P><input type="submit" value="提交"> | <input type="reset"></P>
    </form>
  </body>

  <%--这里提交的路径，需要寻找到项目的类路径--%>
  <form action="${pageContext.request.contextPath}/pic" method="get">
    用户名:<input type="text" name="name"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit">
  </form>
</html>
