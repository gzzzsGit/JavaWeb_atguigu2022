package com.gzzz.transaction;

import com.gzzz.utils.JdbcUtilsV2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * className: BankDao
 * Package : com.gzzz.api.transaction
 * Description:
 *
 * @Author gzzz
 * @Create 2023/10/21 20:16
 * @Version 1.0
 */
public class BankDao {
    public void add(String accountName, int money) throws  SQLException {
        //2. 获取连接
        Connection connection = JdbcUtilsV2.getConnection();

        //3.编写sql
        String sql = "UPDATE t_bank SET money = money+? WHERE account = ?";

        //4.创建preparedStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //5.占位符赋值
        preparedStatement.setInt(1, money);
        preparedStatement.setString(2, accountName);

        //6.执行sql
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            System.out.println("转账成功");
        } else {
            System.out.println("转账失败");
        }

        //7.关闭资源
        preparedStatement.close();
    }

    public void sub(String accountName, int money) throws ClassNotFoundException, SQLException {
        //2. 获取连接
        Connection connection = JdbcUtilsV2.getConnection();

        //3.编写sql
        String sql = "UPDATE t_bank SET money = money-? WHERE account = ?";

        //4.创建preparedStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //5.占位符赋值
        preparedStatement.setInt(1, money);
        preparedStatement.setString(2, accountName);

        //6.执行sql
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            System.out.println("转账成功");
        } else {
            throw new RuntimeException("转账失败");
        }

        //7.关闭资源
        preparedStatement.close();
    }
}
