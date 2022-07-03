package top.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author kinoz
 * @Date 2022/7/3 - 14:34
 * @apiNote Cookie在java层面的体现
 * 体现用户上次的访问时间
 */
public class CookieBasic extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");


        //服务器传客户端1个Cookie
        Cookie cookie = new Cookie("lastLoginTime",String.valueOf(System.currentTimeMillis()));//时间戳转换为字符串
        //设置cookie的有效期为一天
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);


        //服务器从客户端获取cookie,cookie会存在多个
        Cookie[] cookies = req.getCookies();

        //判断Cookie是否存在,响应到前端界面
        PrintWriter out = resp.getWriter();
        if (cookies != null){
            out.write("上次访问时间:");
            for (int i = 0; i < cookies.length; i++) {
                Cookie ck = cookies[i];
                //获取cookie名字(key)
                if (ck.getName().equals("lastLoginTime")){
                    //获取cookie的值(value)
                    long time = Long.parseLong(ck.getValue());
                    //时间戳转换为Date类为本地时间
                    Date date = new Date(time);
                    out.write(date.toLocaleString());
                }
            }
        }else {
            out.write("This is your first visits the web!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
