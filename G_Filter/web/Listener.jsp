<%--
  Created by IntelliJ IDEA.
  User: haogu
  Date: 2022/7/7
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--获取session的数量--%>
    <h2>当前在线人数:
    <%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%></h2>
</body>
</html>
