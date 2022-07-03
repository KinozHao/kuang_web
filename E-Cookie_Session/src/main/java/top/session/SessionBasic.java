package top.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author kinoz
 * @Date 2022/7/3 - 18:04
 * @apiNote
 */
public class SessionBasic extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //获取一个session
        HttpSession session = req.getSession();
        //session可以携带Object类型
        session.setAttribute("name",new JavaBean("李华",29));

        //每个session都有自己唯一的session
        String id = session.getId();
        PrintWriter writer = resp.getWriter();

        //通过inNew判断此session的新旧
        if (session.isNew()){
            writer.print("create success!"+id);
        }else {
            writer.print("session is already!"+id);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
