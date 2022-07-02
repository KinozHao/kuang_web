package datashare;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author kinoz
 * @Date 2022/7/1 - 17:33
 * @apiNote 此类用于获取Context里的共享数据
 * 测试gitpush问题
 */
public class AnotherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应头信息
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        ServletContext con = this.getServletContext();

        //获取Context类中提供的username 通过服务器在网页输出
        String username = (String) con.getAttribute("username");

        PrintWriter out = resp.getWriter();
        out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
