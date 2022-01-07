package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
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
        System.out.println("helloServlet程序的别名是:" + servletConfig.getServletName());
        System.out.println("初始化参数username的值:" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值:" + servletConfig.getInitParameter("url"));
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是专门用于处理请求和响应的
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service hello servlet被访问");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 获取请求方式
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    /**
     * 做get请求
     */
    public void doGet() {
        System.out.println("get请求");
    }

    /**
     * 做post请求
     */
    public void doPost() {
        System.out.println("post请求");
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
