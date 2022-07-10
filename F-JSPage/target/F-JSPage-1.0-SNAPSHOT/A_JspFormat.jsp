<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>what is jsp</title>
</head>
<body>
    <%-- jsp表达式 --%>
    <%= new java.util.Date()%>
    <hr>

    <%-- jsp脚本片段 --%>
    <%
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum+=i;
        }
        out.write("<h1>100内和:"+sum+"</h1>");
    %>

    <hr>
    <%
        int x = 10;
        out.println(x);
    %>
    <p>This is a JDP DOC</p>
    <%
        int y = 20;
        out.println(y);
    %>

    <hr>

    <%--循环htmldaima--%>
    <%
        for (int i = 0; i < 5; i++) {
    %>
    <h1>hell jsp<%=i%></h1>
    <%--EL表达式--%>
    <h1>hell jsp${i}</h1>
    <%
        }
    %>

    <%--JSP声明 会被编写在jsp生成java的类中
        其他的会被声明在_jspService方法中!
    --%>
    <%!
        static {
            System.out.println("this is a static code_space");
        }
        private final int SIX = 6;
        public void testMethod(){
            System.out.println("started a servlet");
        }
    %>


</body>
</html>
