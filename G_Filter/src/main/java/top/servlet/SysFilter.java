package top.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author kinoz
 * @Date 2022/7/7 - 16:34
 * @apiNote
 */
public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //session为空直接跳转到error
        if (req.getSession().getAttribute("USER_SESSION") == null){
            resp.sendRedirect("/error.jsp");
        }


        filterChain.doFilter(servletRequest,servletResponse);
    }
}
