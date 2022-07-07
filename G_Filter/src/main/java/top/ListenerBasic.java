package top;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * @author kinoz
 * @Date 2022/7/7 - 14:13
 * @apiNote 监听器的使用
 */
public class ListenerBasic implements HttpSessionListener {

    //每创建一个session就触发一次这个事件
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext sct = se.getSession().getServletContext();
        Integer num = (Integer) sct.getAttribute("OnlineCount");

        if (num == null){
            num = new Integer(1);
        }else {
            int count = num.intValue();
            num = new Integer(count++);
        }

        sct.setAttribute("OnlineCount",num);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext sct = se.getSession().getServletContext();
        //手动销session
        se.getSession().invalidate();
        Integer num = (Integer) sct.getAttribute("OnlineCount");

        if (num == null){
            num = new Integer(0);
        }else {
            int count = num.intValue();
            num = new Integer(count--);
        }

        sct.setAttribute("OnlineCount",num);
    }
}
