package com.gzzz.transaction;

import com.gzzz.utils.JdbcUtilsV2;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * className: BankService
 * Package : com.gzzz.api.transaction
 * Description:
 *
 * @Author gzzz
 * @Create 2023/10/21 20:17
 * @Version 1.0
 */
public class BankService{

    /**
     * TODO:
     *      事务添加是在业务方法中!
     *      利用try catch代码块，开启事务和提交事务，和事务回滚!
     *      将connection传入dao层即可! dao只负责使用，不要close();
     */
    public void transfer (String fromAccount, String toAccount, int money) throws SQLException, ClassNotFoundException {
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

            //3.提交事务
            connection.commit();
            System.out.println("--*------------------------------*--");
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
