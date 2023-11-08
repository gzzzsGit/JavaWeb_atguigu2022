package com.gzzz.servlets;

import com.gzzz.dao.BankDao;
import com.gzzz.pojo.Result;
import com.gzzz.utils.JdbcUtilsV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * className: IndexServlet
 * Package : com.gzzz.servlets
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/1 12:49
 * @Version 1.0
 */

/**
 * TODO:
 *      Servlet从3.0版本开始支持注解方式的注册，不用去设置web.xml
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get方式下不需要设置编码（tomcat8之后）
        //post方式下，设置编码，防止中文乱码，这句话必须在所有的获取参数动作之前，如果放在任一句之后都会导致之后还会出现中文乱码
        req.setCharacterEncoding("utf-8");

        String fromAccount = req.getParameter("fromAccount");
        System.out.println(fromAccount);
        String fmoney = req.getParameter("fmoney");
        Integer money = Integer.parseInt(fmoney);
        String toAccount = req.getParameter("toAccount");

        try {
            Result res = transfer(fromAccount, toAccount, money);
            HttpSession session = req.getSession();
            session.setAttribute("fromAccount",res);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Result transfer (String fromAccount, String toAccount, int money) throws SQLException, ClassNotFoundException {
        //一个事务的最基本要求，是同一个连接对象
        //一个转账方法属于一个事务（加钱、减钱为一个整体）

        //2.获取连接
        Connection connection = JdbcUtilsV2.getConnection();

        BankDao bankDao = new BankDao();
        try {
            //1.开启事务
            //2.关闭事务自动提交

            //3.执行数据库操作
            connection.setAutoCommit(false);
            bankDao.sub(fromAccount, money);
            System.out.println("--*------------------------------*--");
            bankDao.add(toAccount, money);
            Result res = bankDao.query(fromAccount);

            //3.提交事务
            connection.commit();
            System.out.println("--*------------------------------*--");

            return res;
        } catch (Exception e) {
            //4.回滚事务
            connection.rollback();
            throw new RuntimeException(e);
        }finally {
            //4.关闭事务
            connection.close();
        }
    }
}
