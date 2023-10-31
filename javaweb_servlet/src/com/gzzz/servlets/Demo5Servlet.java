package com.gzzz.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * className: com.gzzz.servlets.Demo5Servlet
 * Package : PACKAGE_NAME
 * Description:
 * TODO:
 *      演示从别的session已保存的作用域获取数据
 * @Author gzzz
 * @Create 2023/11/1 1:17
 * @Version 1.0
 */
public class Demo5Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = (String) req.getSession().getAttribute("name");
        System.out.println(name);
    }
}
