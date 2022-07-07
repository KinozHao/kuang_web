package top.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author kinoz
 * @Date 2022/7/7 - 15:45
 * @apiNote
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端的数据
        String username = req.getParameter("username");

        //登录成功重定向到success主页
        if (username.equals("admin")){
            //获取它的session多个页面都可获取
            req.getSession().setAttribute("USER_SESSION",req.getSession().getId());
            resp.sendRedirect(req.getContextPath()+"/sys/success.jsp");
        //登录失败重定向到错误页面
        }else {
            resp.sendRedirect(req.getContextPath()+"/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
