package com.gzzz.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * className: Demo7Servlet
 * Package : com.gzzz.servlets
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/1 9:09
 * @Version 1.0
 */
public class Demo7Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo7...");
    }
}
