package com.gzzz.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * className: Demo4Servlet
 * Package : com.gzzz.servlets
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/1 1:16
 * @Version 1.0
 */
public class Demo4Servlet extends HttpServlet {
    //演示session保存作用域
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("name", "gzzz");

    }
}
