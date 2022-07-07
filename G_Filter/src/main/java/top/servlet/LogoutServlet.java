package top.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author kinoz
 * @Date 2022/7/7 - 16:19
 * @apiNote
 */
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //频繁创建session消耗资源
        Object user_session = req.getSession().getAttribute("USER_SESSION");
        if (user_session != null){
            //移除掉sessionID 重定义到登录页,可确保session最终还是存在的只是对应的key被移除
            req.getSession().removeAttribute("USER_SESSION");
            resp.sendRedirect("/login.jsp");
        }else {
            resp.sendRedirect("/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
