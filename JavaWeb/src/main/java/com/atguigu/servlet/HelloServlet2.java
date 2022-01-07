package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lanjuwen
 * @create 2022-01-06  21:57
 */
public class HelloServlet2 extends HttpServlet {
    /**
     * 在get请求中调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("httpservlet的helloservlet2的doGet方法");
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);
    }

    /**
     * 在post请求中调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("httpservlet的helloservlet2的doPost方法");
    }
}
