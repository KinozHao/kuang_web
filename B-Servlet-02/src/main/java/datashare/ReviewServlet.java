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
 * @Date 2022/7/1 - 16:50
 * @apiNote 此类获取DataShare类中所提供的共享数据
 * @see DataShare
 */
public class ReviewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应信息
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        ServletContext con = this.getServletContext();
        String username = (String) con.getAttribute("username");
        PrintWriter out = resp.getWriter();
        out.println(username);

    }
}
