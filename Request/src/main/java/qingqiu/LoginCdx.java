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

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doGet(req, resp);
        //防止页面乱码
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        //处理请求
        String name = req.getParameter("name");
        String pass = req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobbies");

        //后台console显示
        System.out.println("========用户信息========");
        System.out.println(name);
        System.out.println(pass);
        System.out.println(Arrays.toString(hobbies));
        System.out.println("=======================");

        //判断与指定参数是否相同,做出跳转和console的警告提示
        /*if (name.equals("Tom")&&pass.equals("123456")) {
            resp.sendRedirect("/rt/success.jsp");
        }else {
            resp.sendRedirect("/rt/index.jsp");
            System.out.println("用户或密码错误");
        }*/

        //通过请求转发 /就代表当前项目无需再写具体名称
        req.getRequestDispatcher("/success.jsp").forward(req,resp);
    }
}
