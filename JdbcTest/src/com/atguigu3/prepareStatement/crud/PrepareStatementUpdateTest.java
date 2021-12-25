package com.atguigu3.prepareStatement.crud;

import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @author lanjuwen
 * @create 2021-12-25  16:14
 */
/*
* 使用PrepareStatement 替代Statement实现crud
* */
public class PrepareStatementUpdateTest {
    @Test
    public void testCommonUpdate() {
//        String sql = "delete from customers where id = ?";
//        update(sql, 19);

        String sql = "update `order` set order_name = ? where order_id = ?";
        update(sql, "DD", "2");
    }

    // 针对不同表的通用的增删改操作
    public void update(String sql, Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1 获得数据库的连接
            conn = JDBCUtils.getConnection();
            //2 预编译sql语句， 返回prepareStatement对象
            ps = conn.prepareStatement(sql);
            // 3 填充占位符
            for (int i = 0; i < args.length; i ++ ) {
                ps.setObject(i + 1, args[i]);
            }
            // 4 执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5 资源关闭
            JDBCUtils.closeResource(conn, ps);
        }
    }

    // 修改customers表中的一条记录
    public void testUpdate() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1 获取连接
            conn = JDBCUtils.getConnection();

            // 2 预编译sql
            String sql = "update customers set name = ? where id = ?";
            ps = conn.prepareStatement(sql);

            // 3 填充占位符
            ps.setObject(1, "莫扎特");
            ps.setObject(2, 18);
            // 4 执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 5 资源的关闭
        JDBCUtils.closeResource(conn, ps);
    }

    // 向customers表中添加一条记录
    @Test
    public void testInsert() {
        Connection conn  = null;
        PreparedStatement ps = null;
        try {
            // 1 加载基本信息
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(is);

            String url = pros.getProperty("url");
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String driverClass = pros.getProperty("driverClass");

            // 2 加载驱动
            Class.forName(driverClass);

            // 3 获得连接
            conn = DriverManager.getConnection(url, user, password);

            System.out.println(conn);

            // 4 预编译sql语句，返回prepareStatement对象
            String sql = "insert into customers(name, email, birth) values(?, ?, ?)";
            ps = conn.prepareStatement(sql);

            // 5 填充占位符
            ps.setString(1, "哪吒");
            ps.setString(2, "nezha@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1000-01-01");
            ps.setDate(3, new Date(date.getTime()));

            // 6 执行操作
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    }
}
