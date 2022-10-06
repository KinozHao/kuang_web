package context_us;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author kinoz
 * @Date 2022/7/2 - 9:56
 * @apiNote 通过InitParameter,获取web.xml下提供的初始化参数
 */
public class InitParam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应头
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        //获取context对象
        ServletContext sct = this.getServletContext();
        //获取xml中配置的初始参数
        String ipr = sct.getInitParameter("jdbc");
        PrintWriter out = resp.getWriter();
        out.println(ipr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
