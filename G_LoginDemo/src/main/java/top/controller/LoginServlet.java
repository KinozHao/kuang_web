package top.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.param_static.Sessions;

import java.io.IOException;

/**
 * @author kinoz
 * @Date 2022/7/7 - 18:51
 * @apiNote 登陆逻辑
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //1.获取前端数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2.判断数据
        if (username.equals("admin") && password.equals("123456")){
            //2.1 获取session存放在server 实现多页面共享
                //2.1.1 session的key定义在一个常量类中
            req.getSession().setAttribute(Sessions.var,req.getSession().getId());
            //2.2 登录成功跳转
            resp.sendRedirect("/sys/success.jsp");
        }else {
            //2.3 登录失跳转
            resp.sendRedirect("/failed.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
