package top;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @author kinoz
 * @Date 2022/7/7 - 11:01
 * @apiNote 重点 web过滤器
 */
public class FilterBasic implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //会在服务器启动的同时触发
        System.out.println("web server init");
    }

    ///过滤方法 主要是对request和response进行一些处理，然后交给下一个过滤器或Servlet处理
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        //后面可能会有其他的过滤器，保过滤器继续同行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    //当服务器关闭过滤器即销毁
    @Override
    public void destroy() {
        System.out.println("filter destroyed");
    }
}
