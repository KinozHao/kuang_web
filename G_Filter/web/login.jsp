<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/servlet/login" method="get">
        <input type="text" name="username">
        <input type="submit">
    </form>
</body>
</html>
