package top.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.entity.Sessions;

import java.io.IOException;

/**
 * @author kinoz
 * @Date 2022/7/7 - 19:12
 * @apiNote
 */
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取用户session
        Object user_session = req.getSession().getAttribute(Sessions.var);

        //2. 判断session
        if (user_session != null){
            //session只要存在,移去它的参数但不移除session 减少session的创建，充分利用资源
            req.getSession().removeAttribute(Sessions.var);
            resp.sendRedirect("/Login.jsp");
        }else {
            resp.sendRedirect("/Login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
