package com.servlet;

import com.entity.User;
import com.util.Sendmail;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author kinoz
 * @Date 2022/7/12 - 16:24
 * @apiNote
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        User user = new User(username, password, email);
        System.out.println(user);

        Sendmail send = new Sendmail(user);
        //使用run网站要等到发送成功才会跳转,影响用户体验
        //sendmail.run();
        send.start();

        req.setAttribute("message","邮件会在3-5分钟后发送致你的邮箱。。。");
        req.getRequestDispatcher("info.jsp").forward(req,resp);
    }
}
