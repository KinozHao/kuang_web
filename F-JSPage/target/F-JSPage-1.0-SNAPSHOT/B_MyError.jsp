<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--发生错误就跳转到定制错误页面--%>
<%@ page errorPage="error/500.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--此结果必然报错--%>
    <% int x = 1/0;%>
</body>
</html>
