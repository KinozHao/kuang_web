package xiangying;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author kinoz
 * @Date 2022/7/2 - 14:30
 * @apiNote ʹ��Responseʵ�������ļ�Ч��
 */
public class FileDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //������Ӧͷ,��ֹ����
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        //1.���ַ�ʽ����ļ�·��
        String localPath = "E:\\JavaCode\\Maven_Study\\Response\\target\\classes\\�й�����.jpg";
        //ͨ��context��ȡ��·����tomcat���£��������ǵ�webĿ¼�£�
        //String localPath = this.getServletContext().getRealPath("/�й�����.jpg");
        System.out.println("��ȡ�ı�·��"+localPath);

        //2.���ص��ļ�����ɶ ͨ��String������ȡ
        String filename = localPath.substring(localPath.lastIndexOf("\\")+1);

        //3.�������֧��(Content-Disposition)����Ҫ���صĶ���,ʹ��URLEncoder�����ļ����Ʋ�����
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(filename,"utf-8"));

        //4.�����ļ���������
        FileInputStream fsm = new FileInputStream(localPath);

        //5.��ȡ���������
        ServletOutputStream serverOSM = resp.getOutputStream();

        //6.������
        int len = 0;
        byte[] bytes = new byte[1024];
        //���ļ�д�뻺������ʹ������������ݷ��͵��ͻ���
        while ((len = fsm.read(bytes)) != -1){
            serverOSM.write(bytes,0,len);
        }


        //7.�ͷ���
        fsm.close();
        serverOSM.close();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
