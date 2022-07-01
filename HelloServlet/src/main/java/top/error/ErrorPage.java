package top.error;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author kinoz
 * @Date 2022/7/1 - 15:54
 * @apiNote 自定义error页面 当访问资源不存在时候跳转此页面
 */
public class ErrorPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<center><h1>404 not found!!!</h1>");
        out.println("<h1>404 页面走丢 不存在!!!</h1>");
        out.println("<h1>404 not found!!!</h1></center>");

        System.out.println("for the console this page is user input a error location will skip to Our ErrorPage");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
