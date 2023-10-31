package com.gzzz.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * className: Demo1Servlet
 * Package : com.gzzz.servlets
 * Description:
 * TODO:
 *     演示没有重写get方法直接访问的405错误
 * @Author gzzz
 * @Create 2023/10/30 20:30
 * @Version 1.0
 */
public class Demo1Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
