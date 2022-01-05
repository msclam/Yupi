package com.atguigu.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lanjuwen
 * @create 2022-01-05  22:01
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1 构造器");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是专门用于处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service hello servlet被访问");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 销毁");
    }
}
