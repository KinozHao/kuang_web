package com.mail;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author kinoz
 * @Date 2022/7/12 - 16:11
 * @apiNote
 */
public class PicSend {
    public static void main(String[] args) throws GeneralSecurityException, MessagingException {
        Properties prop = new Properties();
        prop.setProperty("mail.host","smtp.qq.com");
        prop.setProperty("mail.transport.protocol","smtp");
        prop.setProperty("mail.smtp.auth","true");
        //QQ邮箱需要设置SSL加密,实际测试则不需要
        MailSSLSocketFactory sf=new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable","false");
        prop.put("mail.smtp.ssl.socketFactory",sf);

        //使用javaMail发送邮件的5个步骤
        //1.创建定义整个应用程序所需要的环境信息的session对象
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("xxx@qq.com","授权码");
            }
        });
        //开启session的debug模式，这样可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2.通过session得到transport对象
        Transport ts=session.getTransport();
        //3.使用邮箱的用户名和授权码连上邮件服务器
        ts.connect("smtp.163.com",25,"xxx@qq.com","授权码");
        //4.创建邮件：写文件
        //注意需要传递session
        MimeMessage message=new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress("xxx@qq.com"));
        //指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("xxx@xxx.com"));



        //邮件标题
        message.setSubject("发送的标题");
        //邮件的图片内容
        MimeBodyPart image = new MimeBodyPart();
        //图片需要经过数据处理 此类用于处理数据
        DataHandler dh = new DataHandler(new FileDataSource("图片路径"));
        image.setDataHandler(dh);//在boyd中放入这个处理的图片数据
        image.setContentID("pic.jpg");//给图片设置id标识
        //准备正文数据
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("带有图片的email<img src='cid:'pic.jpg'>","text/html;charset=utf-8");

        //描述数据关系
        MimeMultipart MM = new MimeMultipart();
        MM.addBodyPart(text);
        MM.addBodyPart(image);
        MM.setSubType("related");
        //5.发送邮件
        ts.sendMessage(message,message.getAllRecipients());

        //6.关闭连接
        ts.close();
    }
}
