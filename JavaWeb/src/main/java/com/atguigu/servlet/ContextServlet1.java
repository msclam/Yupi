package com.atguigu.servlet; /**
 * @author lanjuwen
 * @create 2022-01-07  9:49
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        getServletConfig().getServletContext();
        // 获取servletContext对象
        ServletContext context = getServletContext();
        System.out.println("未赋值之前的context1中key1的值是: " + context.getAttribute("key1"));
        context.setAttribute("key1", "value1");
        System.out.println("context1中key1的值是: " + context.getAttribute("key1"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
