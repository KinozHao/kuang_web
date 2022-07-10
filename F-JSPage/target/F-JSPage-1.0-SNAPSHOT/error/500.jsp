<%--定制500错误页面--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%-- 使用EL表达式获取图片路径   --%>
    <img src=${pageContext.request.contextPath}/img/500error.jpg alt="500Error">
</body>
</html>