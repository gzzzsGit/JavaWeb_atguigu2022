package com.gzzz.servlets;

import com.gzzz.transaction.BankService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * className: servlet
 * Package : com.gzzz.servlets
 * Description:
 *
 * @Author gzzz
 * @Create 2023/10/23 17:26
 * @Version 1.0
 */
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fromAccount = req.getParameter("fromAccount");
        String fmoney = req.getParameter("fmoney");
        Integer money = Integer.parseInt(fmoney);
        String toAccount = req.getParameter("toAccount");

        BankService bankService = new BankService();
        try {
            bankService.transfer(fromAccount,toAccount,money);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
