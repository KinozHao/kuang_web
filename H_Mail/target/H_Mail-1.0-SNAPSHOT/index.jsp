<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/register.do" method="post">
        <div class="info">${error}</div>
        账号<input type="text" name="username"><br>
        密码<input type="password" name="password"><br>
        邮箱<input type="text" name="email"><br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
