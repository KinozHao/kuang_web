<%@ page import="top.entity.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--测试Person entity--%>
    <%
        /*Person person = new Person();
        person.setAddress();
        person.setAge();
        person.setName();*/
    %>
    <%--等价于上面--%>
    <%--1.获取一个实体类--%>
    <jsp:useBean id="person" class="top.entity.Person" scope="page"/>
    <%--2.添加参数--%>
    <jsp:setProperty name="person" property="name" value="LeeMing"/>
    <jsp:setProperty name="person" property="age" value="19"/>
    <jsp:setProperty name="person" property="address" value="17Street NewYork"/>
    <%--3.反馈到页面--%>
    name:<jsp:getProperty name="person" property="name"/>
    age:<jsp:getProperty name="person" property="age"/>
    address:<jsp:getProperty name="person" property="address"/>

</body>
</html>
