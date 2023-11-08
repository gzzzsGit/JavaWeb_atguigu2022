package com.gzzz.utils;

/**
 * className: JdbcUtilsV2
 * Package : com.gzzz.api.utils
 * Description:
 *
 * @Author gzzz
 * @Create 2023/10/22 0:52
 * @Version 1.0
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


/**
 * TODO: 优化JdbcUtils
 *      利用线程本地变量ThreadLocal,存储连接信息!确保一个线程的多个方法可以获取同一个connection!
 *      优势: 事务操作的时候service 和 dao 属于同一个线程,不用再传递参数了!
 *           它们都可以调用getConnection获取相同的连接池!
 */
public class JdbcUtilsV2 {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    public static DataSource dataSource = null;

    static {
        //初始化连接池对象
        dataSource = new DruidDataSource();
        Properties properties = new Properties();
        InputStream is = null;
        try {
            //获取当前运行路径
            //D:\develop_tools\apache-tomcat-8.5.15\bin
            System.out.println(System.getProperty("user.dir"));
            //路径为当前运行路径/druid.properties
            is = new FileInputStream("druid.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        //如果当前线程本地量为空,则创建当前线程的连接并返回
        if (threadLocal.get() == null) {
            threadLocal.set(dataSource.getConnection());
        }
        //如果当前线程本地量不为空,则获取当前线程本地量中的连接并返回
        return threadLocal.get();
    }

    public static void recycleConnection(Connection connection) throws SQLException {
        if (threadLocal.get() != null) {
            //清空线程本地量中的数据
            threadLocal.remove();

            //设置自动提交回为true，防止改了忘记复原
            connection.setAutoCommit(true);
            connection.close();
        }
    }

}
