package com.down;



import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author kinoz
 * @Date 2022/7/2 - 14:30
 * @apiNote 使用Response实现下载文件效果
 */
public class FileDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应头,防止乱码
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        //1.两种方式获得文件路径
        String localPath = "E:\\JavaCode\\Maven_Study\\C_FileUpAndDown\\target\\classes\\服务器资源.jpg";
        System.out.println("获取文本路径"+localPath);
        //通过context获取的路径在tomcat包下，并非我们的web目录下！
        //String localPath = this.getServletContext().getRealPath("/服务器资源.jpg");
        //System.out.println("获取文本路径"+this.getServletContext().getRealPath("/服务器资源.jpg"));

        //2.下载的文件名是啥 通过String方法截取
        String filename = localPath.substring(localPath.lastIndexOf("\\")+1);

        //3.让浏览器支持(Content-Disposition)我们要下载的东西,使用URLEncoder设置文件名称不乱码
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(filename, StandardCharsets.UTF_8));

        //4.下载文件的输入流
        FileInputStream fsm = new FileInputStream(localPath);

        //5.获取输出流对象
        ServletOutputStream serverOSM = resp.getOutputStream();

        //6.缓冲区
        int len = 0;
        byte[] bytes = new byte[1024];
        //把文件写入缓冲区，使用输出流把数据发送到客户端
        while ((len = fsm.read(bytes)) != -1){
            serverOSM.write(bytes,0,len);
        }

        //7.释放流
        fsm.close();
        serverOSM.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
