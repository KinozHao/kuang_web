package topII.context_us;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * @author kinoz
 * @Date 2022/7/2 - 10:35
 * @apiNote 通过properties和context实现从配置文件读取信息输出到前端
 */
public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        ServletContext sct = this.getServletContext();
        InputStream in = sct.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
        Properties prop = new Properties();
        prop.load(in);
        PrintWriter out = resp.getWriter();
        out.println(prop.getProperty("driverClassName"));
        out.println(prop.getProperty("username"));
        out.println(prop.getProperty("password"));


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
