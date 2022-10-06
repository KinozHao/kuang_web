package datashare;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Test;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author kinoz
 * @Date 2022/7/1 - 17:23
 * @apiNote 此类提供一个名为李晓明的对象
 */
public class DataShare extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        /*常用获取方法
        this.getInitParameter(); 获取初始化参数
        this.getServletConfig(); 获取配置参数
        this.getServletContext(); 获取上下文*/

        //通过this调用一个ServletContext对象用于设置各种资源
        ServletContext con = this.getServletContext();
        String username = "李晓明";
        //设置一个属性以键值对的方式作为共享资源
        con.setAttribute("username",username);

        PrintWriter out = resp.getWriter();
        //page prompt!
        out.println("<center><H1>This page you will got shares-resources</H1></center>");
        out.println("<center><H1>And then visit another page will receive the resources</H1></center>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
