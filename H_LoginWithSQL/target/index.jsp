<%--
  Created by IntelliJ IDEA.
  User: haogu
  Date: 2022/7/11
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
    <form action="${pageContext.request.contextPath}/checkins" method="get">
      <div class="info">${error}</div>
      账号<input type="text" name="name"><br>
      密码<input type="text" name="pwd"><br>
      <input type="submit" value="login">
    </form>
  </body>
</html>
