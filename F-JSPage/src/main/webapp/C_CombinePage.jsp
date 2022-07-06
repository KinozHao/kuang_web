<%--测试网站通用信息--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>C_CombinePage.jsp</title>
</head>
<body>
    <%--@include会将两个页面合二为一--%>
    <%@include file="common/header.jsp"%>
    <h2>我是用的是jsp指令集</h2>
    <%@include file="common/footer.jsp"%>
    <hr>

    <%--jsp标签--%>
    <jsp:include page="common/header.jsp"/>
    <h2>我是用的是jsp标签</h2>
    <jsp:include page="common/footer.jsp"/>
</body>
</html>
