<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
</body>

<%--这里提交的路径，需要寻找到项目的类路径--%>
<form action="${pageContext.request.contextPath}/pic" method="get">
    用户名:<input type="text" name="name"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit">
</form>
</html>