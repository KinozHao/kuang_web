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
 * @Date 2022/7/3 - 18:16
 * @apiNote 获取SessionBasic里提供的attribute中的参数
 */
public class SessionGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //通过session的attribute方法以键值对方法获取参数
        HttpSession session = req.getSession();
        Object name = session.getAttribute("name");

        //把获取的数据响应到前端页面
        PrintWriter out = resp.getWriter();
        out.print(name);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
