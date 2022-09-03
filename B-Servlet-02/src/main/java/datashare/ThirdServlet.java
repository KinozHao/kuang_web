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
 * @Date 2022/7/1 - 20:10
 * @apiNote 此类用于获取Context里的共享数据
 */
public class ThirdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应信息
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        ServletContext svt = this.getServletContext();
        String username = (String) svt.getAttribute("username");
        PrintWriter out = resp.getWriter();
        out.println(username);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
