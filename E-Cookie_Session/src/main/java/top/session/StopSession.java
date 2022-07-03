package top.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author kinoz
 * @Date 2022/7/3 - 18:26
 * @apiNote 停掉session
 */
public class StopSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //移除session参数
        session.removeAttribute("name");
        //手动注销session
        session.invalidate();

        PrintWriter out = resp.getWriter();
        out.print("<H1>session remove success please refresh</H1>");

        System.out.println("session已经去除");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
