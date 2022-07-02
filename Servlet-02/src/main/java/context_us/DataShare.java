package context_us;

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
 * @apiNote Context一般用于获取上下文连接
 */
public class DataShare extends HttpServlet {
    @Test
    // TODO: 2022/7/1 如何让从数据库中读取到的数据通过Context直接在web中共享?
    public void SqlTest(){
        Connection sql_con = null;
        try {
            sql_con = dbcp_utils.getConnection();
            Statement sta = sql_con.createStatement();
            String sql_text = "select `name` from cusinfo where ID=1";
            ResultSet rst = sta.executeQuery(sql_text);
            if (rst.next()){
                String name = (String) rst.getObject("name");
                System.out.println(name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        //常用获取方法
        //this.getInitParameter(); 获取初始化参数
        //this.getServletConfig(); 获取配置参数
        //this.getServletContext(); 获取上下文

        //通过this调用一个ServletContext对象用于设置各种资源
        ServletContext con = this.getServletContext();
        //设置义一个属性以键值对的方式作为共享资源
        String username = "李晓明";
        con.setAttribute("username",username);
        PrintWriter out = resp.getWriter();
        //page prompt!
        out.println("<center><H1>This page you will got shares-resources</H1></center>");
        out.println("<center><H1>And then visit another page will receive the resources</H1></center>");
        //console prompt!
        System.out.println("resource Acquisition Succeeded!!!!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
