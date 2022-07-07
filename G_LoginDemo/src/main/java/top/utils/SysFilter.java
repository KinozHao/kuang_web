package top.utils;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.param_static.Sessions;

import java.io.IOException;

/**
 * @author kinoz
 * @Date 2022/7/7 - 19:30
 * @apiNote
 */
public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.把形参转换为我们需要的类型
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //2.若session值为空就跳转失败页面
        if (req.getSession().getAttribute(Sessions.var) == null){
            resp.sendRedirect("/failed.jsp");
        }
        //3. //后面可能会有其他的过滤器，保过滤器继续同行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
