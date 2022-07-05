<%--测试网站通用信息--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--@include会将两个页面合二为一--%>
    <%@include file="common/header.jsp"%>
    <h1>网页主体0</h1>
    <%@include file="common/footer.jsp"%>
    <hr>

    <%--jsp标签--%>
    <jsp:include page="common/header.jsp"/>
    <h1>网页主体0</h1>
    <jsp:include page="common/footer.jsp"/>
</body>
</html>
