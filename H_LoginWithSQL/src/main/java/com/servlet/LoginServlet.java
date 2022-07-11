package com.servlet;

import com.entity.User;
import com.mysql.jdbc.StringUtils;
import com.service.LoginServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author kinoz
 * @Date 2022/7/11 - 16:37
 * @apiNote
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        User user = new LoginServiceImpl().getLoginUser(name,pwd);

        if (user != null){
            req.getSession().setAttribute("session",user);
            resp.sendRedirect("/success.jsp");
        }else {
            req.setAttribute("error","用户名或密码不正确");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
