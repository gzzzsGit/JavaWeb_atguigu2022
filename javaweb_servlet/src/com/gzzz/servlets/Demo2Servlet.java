package com.gzzz.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * className: Demo2Servlet
 * Package : com.gzzz.servlets
 * Description:
 * TODO:
 *   测试servlet生命周期
 * @Author gzzz
 * @Create 2023/10/30 21:45
 * @Version 1.0
 */
public class Demo2Servlet extends HttpServlet {
    public Demo2Servlet() {
        System.out.println("实例化... ");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("正在初始化");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("正在服务");
    }

    @Override
    public void destroy() {
        System.out.println("正在销毁");
    }
}
