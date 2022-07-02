package top.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
/**
 * @author kinoz
 * @Date 2022/7/1 - 10:49
 * @apiNote 一个简单的动态servlet
 */
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        System.out.println("这是一个servlet项目！");
        //响应的类型 html
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //获取响应的输入流
        out.println("<html>");
        out.println("<body>");
        out.println("<head>");
        out.println("<title>你好服务器</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>测试中文编码及</h3>");
        out.println("<h3>Hello world</h3>");
        out.println("</body>");
        out.println("</html>");
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        doGet(request, response);

    }

}
