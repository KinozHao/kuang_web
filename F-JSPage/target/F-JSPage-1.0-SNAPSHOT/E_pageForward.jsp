<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.forward("/common/E_forwardpage.jsp");
        //等同于request.getRequestDispatcher("/D_pageContext.jsp").forward(request,response);
    %>
</body>
</html>
