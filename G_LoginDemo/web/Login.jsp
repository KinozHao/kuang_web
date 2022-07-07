<%--
  Created by IntelliJ IDEA.
  User: haogu
  Date: 2022/7/7
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/servlet/login" method="get">
        账号<input type="text" name="username"><br>
        密码<input type="text" name="password"><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
