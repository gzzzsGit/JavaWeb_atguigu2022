package com.gzzz.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * className: Demo3Servlet
 * Package : com.gzzz.servlets
 * Description:
 * TODO:
 *    测试获取session、如果获取不到，则创建一个新的
 * @Author gzzz
 * @Create 2023/10/31 23:30
 * @Version 1.0
 */
public class Demo3Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //request.getsession () ->获取当前的会话，没有则创建一个新的会话
        HttpSession session = req.getSession();

        //session.isNew() ->判断当前会话是否为新创建的
        System.out.println("session是新的吗："+session.isNew());
        //session.getId() ->获取当前会话的ID
        System.out.println("Session ID:"+session.getId());

        //设置session非激活间隔时长为10分钟，默认为1800秒即30分钟
        session.setMaxInactiveInterval(600);

        //强制让会话失效
//        session.invalidate();
    }
}
