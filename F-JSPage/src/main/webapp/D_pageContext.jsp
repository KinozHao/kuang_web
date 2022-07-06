<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>D_pageContext.jsp</title>
</head>
<body>
    <!--PageContext下setAttribute底层源码分析-->
    <%/*
            public void setAttribute(String name, Object attribute, int scope) {
            switch(scope) {
            case 1:
                this.mPage.put(name, attribute);
                break;
            case 2:
                this.mRequest.put(name, attribute);
                break;
            case 3:
                this.mSession.put(name, attribute);
                break;
            case 4:
                this.mApp.put(name, attribute);
                break;
            default:
                throw new IllegalArgumentException("Bad scope " + scope);
            }

        }*/%>
    <%--jsp内置对象--%>
    <%
        pageContext.setAttribute("name1","Tom1");   //数据只在一个页面有效
        request.setAttribute("name2","Tom2");       //数据只在一次请求中有效，请求转发会携带此参数
        session.setAttribute("name3","Tom3");       //数据只在一次会话中有效，打开IE到关闭IE
        //application actually is HttpServletContext just changed the name
        application.setAttribute("name4","Tom4");   //数据持久有效,因为在server中除非server断开
        //此写法等同于 session.setAttribute();
        pageContext.setAttribute("car","bmw",PageContext.SESSION_SCOPE);
    %>
    <%
        /*从底层到高层去寻找(作用域)*/
        String name1 = (String) pageContext.findAttribute("name1");
        String name2 = (String) pageContext.findAttribute("name2");
        String name3 = (String) pageContext.findAttribute("name3");
        String name4 = (String) pageContext.findAttribute("name4");
        String name5 = (String) pageContext.findAttribute("name5");
    %>

    <h1>取出的值</h1>
    <h2>${name1}</h2>
    <h2>${name2}</h2>
    <h2>${name3}</h2>
    <h2>${name4}</h2>
    <%--页面不会显示--%>
    EL表达式:<h2>${name5}</h2>
    <%--页面会显示null--%>
    jsp语法:<h2><%=name5%></h2>
</body>
</html>
