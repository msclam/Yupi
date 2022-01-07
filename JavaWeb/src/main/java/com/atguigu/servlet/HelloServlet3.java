package com.atguigu.servlet; /**
 * @author lanjuwen
 * @create 2022-01-06  22:10
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class HelloServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("httpservlet的helloservlet3的doPost方法");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("httpservlet的helloservlet3的doPost方法");
    }
}
