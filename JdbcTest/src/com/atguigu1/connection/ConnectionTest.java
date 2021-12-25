package com.atguigu1.connection;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author lanjuwen
 * @create 2021-12-25  0:48
 */
public class ConnectionTest {
    @Test
    // 方式一
    public void testConnection1() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();
        // 协议:ip地址://端口号/数据库
        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        Connection conn = driver.connect(url, info);

        System.out.println(conn);
    }

    // 方式二： 方式一的迭代
    @Test
    public void testConnection2() throws Exception {
        // 1 获得Driver实现类对象，使用反射
        Class clazz = Class.forName("com.mysql.jdbc.Driver");

        Driver driver = (Driver) clazz.newInstance();

        // 2 提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test";

        // 3 提供连接需要的用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        // 4 获取连接
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }

    // 方法三 DriverManager替换Driver
    @Test
    public void testConnection3() throws Exception {
        // 1 获取Driver实现类的对象
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 2 提供另外三个连接基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        // 3 注册驱动
        DriverManager.registerDriver(driver);

        // 4 获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    // 方法四 DriverManager替换Driver(可以加载驱动，不用显式注册驱动)
    @Test
    public void testConnection4() throws Exception {
        // 1 获取Driver实现类的对象
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
//        Driver driver = (Driver) clazz.newInstance();

        // 2 提供另外三个连接基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        // 3 注册驱动
//        DriverManager.registerDriver(driver);

        // 4 获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    // 方法五 最终版 将数据库配置的4个基本信息放在配置文件中，通过读取配置文件方式获取连接
    // 好处： 数据和代码的分离，解耦合    修改配置信息，避免程序重新打包
    @Test
    public void testConnection5() throws Exception {
        // 1 读取配置文件的信息
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String url = pros.getProperty("url");
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String driverClass = pros.getProperty("driverClass");

        // 2 加载驱动
        Class.forName(driverClass);

        // 3 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}
