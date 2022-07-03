package xiangying;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author kinoz
 * @Date 2022/7/2 - 15:44
 * @apiNote a random verify_code demo
 */
public class VerifyCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpeg");
        resp.setHeader("refresh","3");
        //让浏览器不会缓存
        resp.setDateHeader("expires",1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        //1.建立一个空白的图片
        BufferedImage img = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        //2.获取画笔
        Graphics2D pencil = (Graphics2D) img.getGraphics();
        //3.对空白的图片进行设置
        pencil.setColor(Color.PINK);
        pencil.fillRect(0,0,80,20);
        pencil.setColor(Color.white);
        pencil.setFont(new Font(null,Font.BOLD,20));
        pencil.drawString(randomNum(),0,20);
        //4.响应到前端页面
        ImageIO.write(img,"jpg",resp.getOutputStream());
    }
    //生成一个随机数作为验证码
    public String randomNum(){
        Random random = new Random();
        return String.valueOf(random.nextInt(9999999));
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
