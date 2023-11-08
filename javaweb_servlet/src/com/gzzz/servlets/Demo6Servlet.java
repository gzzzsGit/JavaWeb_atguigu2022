package com.gzzz.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * className: Demo6Servlet
 * Package : com.gzzz.servlets
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/1 8:56
 * @Version 1.0
 */
public class Demo6Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo6...");
        //服务器内部转发
//        req.getRequestDispatcher("demo7").forward(req, resp);

        //客户端重定向
        resp.sendRedirect("demo7");
    }
}
