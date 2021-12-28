package com.atguigu8.connectionPool.c3p0.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    /**
     * 使用c3p0的数据库连接池技术
     * @return
     * @throws SQLException
     */
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0"); // 池子一个就够，连接多个
    public static Connection getConnection1() throws SQLException {
        Connection connection = cpds.getConnection();
//        System.out.println(connection);
        return connection;
    }


    public static Connection getConnection() throws  Exception {
        // 1 获取配置资源
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String url = pros.getProperty("url");
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String driverClass = pros.getProperty("driverClass");

        // 2 加载驱动
        Class.forName(driverClass);

        // 3 注册驱动和获得连接
        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }

    public static void closeResource(Connection conn, Statement ps) {
        // 7 资源关闭
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        // 7 资源关闭
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
