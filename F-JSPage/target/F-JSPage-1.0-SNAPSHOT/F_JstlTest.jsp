<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--无法运行,可能存在tomcat10crush问题--%>
    <%--<h1>if测试</h1>
    <form action="F_JstlTest.jsp" method="get">
        <input type="text" name="username" value="${param.username}">
        <input type="submit" value="Login in">
    </form>
    &lt;%&ndash;判断提交用户若为admin则登录成功&ndash;%&gt;
    <c:if test="${param.name='admin'}" var="isAdmin">
        <c:out value="管理员登录成功"/>
    </c:if>
    &lt;%&ndash;自闭和标签&ndash;%&gt;
    <c:out value="${isAdmin}"/>--%>

    <hr>
    <h3>when测试 类似switch</h3>
    <%--定义一个变量--%>
    <c:set var="score" value="90"/>
    <c:choose>
        <%--判断分数--%>
        <c:when test="${score >=90}">
            成绩优秀
        </c:when>
        <c:when test="${score <90}">
            成合格
        </c:when>
    </c:choose>

    <hr>
    <%--通过jstl遍历java集合--%>
    <%
        ArrayList<String> person = new ArrayList<>();
        person.add(0,"Tom");
        person.add(1,"Jack");
        person.add(2,"Lisa");
        person.add(3,"Iily");
        person.add(4,"Ocoma");
        request.setAttribute("list",person);
        //等价于下面的jstl表达式
        //person.forEach(System.out::println);
    %>
    <c:forEach var="person" items="${list}">
        <c:out value="${person}"/>
    </c:forEach>
    <br>
    <%--
    var 每一次要遍历出来的变量
    items 要遍历的对象
    begin 从哪儿开始
    end 到哪儿
    step 步长
    --%>
    <c:forEach var="person" items="${list}" begin="1" end="4" step="2">
        <c:out value="${person}"/>
    </c:forEach>
</body>
</html>
