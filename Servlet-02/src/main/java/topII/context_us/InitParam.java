package topII.context_us;

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
 * @apiNote 获取xml下提供的初始化参数 通过InitParameter
 */
public class InitParam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        ServletContext sct = this.getServletContext();
        String ipr = sct.getInitParameter("jdbc");
        PrintWriter out = resp.getWriter();
        out.println(ipr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
