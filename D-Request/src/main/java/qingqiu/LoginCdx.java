package qingqiu;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


/**
 * @author kinoz
 * @Date 2022/7/2 - 16:24
 * @apiNote 重定向体现
 */
public class LoginCdx extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //防止页面乱码
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        //处理请求
        String name = req.getParameter("name");
        String pass = req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobbies");

        //方式1.重定向
        //resp.sendRedirect("/rt/success.jsp");
        //方式2.通过请求转发 /就代表当前项目无需再写具体名称
        req.getRequestDispatcher("/success.jsp").forward(req,resp);


        //Console feedback
        System.out.println("=======USER INFO======");
        System.out.println(name);
        System.out.println(pass);
        System.out.println(Arrays.toString(hobbies));
        System.out.println("=======================");

    }
}
