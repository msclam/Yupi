package com.atguigu.servlet; /**
 * @author lanjuwen
 * @create 2022-01-07  0:38
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletConfig().getServletContext();
        // 从web.xml中获取context-param
        String username = context.getInitParameter("username");
        System.out.println("context-parm的username的值是" + username);
        String password = context.getInitParameter("password");
        System.out.println("context-parm的password的值是" + password);

        System.out.println("获取当前工程路径" + context.getContextPath());

        System.out.println("工程部署的路径是:" + context.getRealPath("/"));
//       // 斜杠被服务器解析地址为:http://ip:port/工程名/ 映射到 IDEA 代码的 web 目录
        System.out.println("工程下 css 目录的绝对路径是:" + context.getRealPath("/css"));
        System.out.println("工程下 imgs 目录 1.jpg 的绝对路径是:" + context.getRealPath("/imgs/1.jpg"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
