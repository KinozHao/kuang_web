<%--
  Created by IntelliJ IDEA.
  User: haogu
  Date: 2022/7/2
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="text-align: center">
        <%--这里提交的路径，需要寻找到项目的类路径--%>
        <form action="${pageContext.request.contextPath}/login" method="get">
            用户名:<input type="text" name="name"><br>
            密码:<input type="password" name="password"><br>
            爱好
            <input type="checkbox" name="hobbies" value="Girls">Girls
            <input type="checkbox" name="hobbies" value="Code">Code
            <input type="checkbox" name="hobbies" value="Math">Math
            <input type="checkbox" name="hobbies" value="Tinnies">Tinnies<br>
            <input type="submit">
            <br>
        </form>
    </div>
</body>
</html>
