package top.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author kinoz
 * @Date 2022/7/3 - 16:24
 * @apiNote 解决中文乱码问题
 */
public class URLEncodeBasic extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = req.getCookies();
        PrintWriter out = resp.getWriter();
        if (cookies != null){
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie =  cookies[i];
                if (cookie.getName().equals("name")){
                    out.print("<H1>名字:"+URLDecoder.decode(cookie.getValue(),StandardCharsets.UTF_8)+"</H1>");
                }
            }
        }else {
            out.write("nothing!");
        }

        Cookie cookie = new Cookie("name", URLEncoder.encode("解决了乱码黑色背景问题！", StandardCharsets.UTF_8));
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
