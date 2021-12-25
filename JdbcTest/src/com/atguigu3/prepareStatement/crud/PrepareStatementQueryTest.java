package com.atguigu3.prepareStatement.crud;

import com.atguigu3.bean.Customer;
import com.atguigu3.bean.Order;
import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lanjuwen
 * @create 2021-12-25  21:41
 */
public class PrepareStatementQueryTest {
    // prepareStatement预编译sql语句能够避免sql注入问题
    // prepareStatement操作blob的数据statement不行
    // prepareStatement可以高效批量操作
    @Test
    public void testGetForList() {
        String sql = "select id, name, email from customers where id < ?";
        List<Customer> list = getForList(Customer.class, sql, 12);
        for (Customer cust : list) {
            System.out.println(cust);
        }

        sql = "select order_id orderId, order_name orderName from `order` where order_id < ?";
        List<Order> list1 = getForList(Order.class, sql, 5);
        for (Order order : list1) {
            System.out.println(order);
        }
    }

    // 不同表的通用查询
    public <T>List<T> getForList(Class<T> clazz, String sql, Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1 获取连接
            conn = JDBCUtils.getConnection();

            // 2 预编译sql
            ps = conn.prepareStatement(sql);
            // 3 填写占位符
            for (int i = 0; i < args.length; i ++ ) {
                ps.setObject(i + 1, args[i]);
            }

            // 4 执行
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCnt = rsmd.getColumnCount();
            // 5 处理结果
            ArrayList<T> list = new ArrayList<>();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCnt; i ++ ) {
                    // 获取列值
                    Object columnValue = rs.getObject(i + 1);
                    // 获取列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    // 通过反射给对象t赋值
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

    @Test
    public void testGetInstanc() {
        String sql = "select id, name, email from customers where id = ?";
        Customer cust = getInstanc(Customer.class, sql, 1);
        System.out.println(cust);

        String sql1 = "select order_id orderId, order_name orderName from `order` where order_id = ?";
        Order order = getInstanc(Order.class, sql1, 1);
        System.out.println(order);
    }

    // 针对不同表的通用查询(返回一条记录)
    public <T> T getInstanc(Class<T> clazz, String sql, Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1 获取连接
            conn = JDBCUtils.getConnection();

            // 2 预编译sql
            ps = conn.prepareStatement(sql);
            // 3 填写占位符
            for (int i = 0; i < args.length; i ++ ) {
                ps.setObject(i + 1, args[i]);
            }

            // 4 执行
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCnt = rsmd.getColumnCount();
            // 5 处理结果
            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCnt; i ++ ) {
                    // 获取列值
                    Object columnValue = rs.getObject(i + 1);
                    // 获取列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    // 通过反射给对象t赋值
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }
}
