package top.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author kinoz
 * @Date 2022/7/3 - 15:56
 * @apiNote 停掉cookie
 */
public class StopCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //服务器响应给客户端一个Cookie
        Cookie cookie = new Cookie("lastLoginTime", String.valueOf(System.currentTimeMillis()));
        //设置它的有效期为0
        cookie.setMaxAge(0);
        //响应到客户端
        resp.addCookie(cookie);

        //页面提示cookie已经停掉
        PrintWriter out = resp.getWriter();
        out.write("cookie has been down pleas reset!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
