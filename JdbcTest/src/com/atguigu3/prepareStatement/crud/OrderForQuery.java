package com.atguigu3.prepareStatement.crud;

import com.atguigu3.bean.Order;
import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author lanjuwen
 * @create 2021-12-25  20:17
 */
public class OrderForQuery {
    // 针对Order表的查询
    @Test
    public void testOrderForQuery() {
        String sql = "select order_id orderId, order_name orderName, order_date orderDate from `order` where order_id = ?";
        OrderForQuery(sql, 1);
    }

    // 通用操作
    public Order OrderForQuery(String sql, Object...args) {
        // 注意：表的字段名和bean的属性名不一致(order_id)对不上orderId
        // 1 声明sql语句时起别名（必须是类的属性名作为别名）
        // 2 resultSetMetaData使用getColumnLabel方法获取列名（无别名，就是列名，有别名，就是别名）
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 1 获得数据库的连接
            conn = JDBCUtils.getConnection();
            // 2 prepareStatement预编译sql
            ps = conn.prepareStatement(sql);

            // 3 设置占位符
            for (int i = 0; i < args.length; i ++ ) {
                ps.setObject(i + 1, args[i]);
            }

            // 4 执行结果
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCnt = rsmd.getColumnCount();
            if (rs.next()) {
                Order order = new Order();
                // 处理结果，返回结果对象（一张表表示一个类）
                for (int i = 0; i < columnCnt; i ++ ) {
                    // 获取列的值
                    Object columnValue = rs.getObject(i + 1);
                    // 获取列的名
//                    String columnName = rsmd.getColumnName(i + 1);
                    // 获取列的别名(无的就获取列名)
                    String columnName = rsmd.getColumnLabel(i + 1);
                    Field field = Order.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(order, columnValue);
                }
                System.out.println(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }
    @Test
    public void testQuery1() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 1 获得数据库的连接
            conn = JDBCUtils.getConnection();
            // 2 prepareStatement预编译sql
            String sql = "select order_id, order_name, order_date from `order` where order_id = ?";
            ps = conn.prepareStatement(sql);

            // 3 设置占位符
            ps.setObject(1, 1);

            // 4 执行结果
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCnt = rsmd.getColumnCount();
            if (rs.next()) {

                // 处理结果，返回结果对象（一张表表示一个类）
                int id = (int) rs.getObject(1);
                String name = (String) rs.getObject(2);
                Date date = (Date) rs.getObject(3);
                Order order = new Order(id, name, date);
                System.out.println(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
    }
}
