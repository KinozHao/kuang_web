package context_us;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author kinoz
 * @Date 2022/7/2 - 10:16
 * @apiNote Request dispatcher 请求转发
 */
public class Rdispatcher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        ServletContext sct = this.getServletContext();
        //方式一 转发的请求路径
        RequestDispatcher rd = sct.getRequestDispatcher("/data");
        //发出上面的指令,通过本类会直接跳到/data资源页面下
        rd.forward(req,resp);

        //方式二
        //req.getRequestDispatcher("/data").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
