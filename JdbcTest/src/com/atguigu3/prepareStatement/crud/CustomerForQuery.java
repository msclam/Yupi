package com.atguigu3.prepareStatement.crud;

import com.atguigu3.bean.Customer;
import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author lanjuwen
 * @create 2021-12-25  17:15
 */
public class CustomerForQuery {
    @Test
    public void testQueryForCustomers() {
        String sql = "select id, name, birth, email from customers where id = ?";
        Customer cust = queryForCustomers(sql, 13);
        System.out.println(cust);
    }

    // 针对customers表的通用查询操作
    public Customer queryForCustomers(String sql, Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1 获取数据库的连接
            conn = JDBCUtils.getConnection();
            // 2 获取prepareStatement对象，编译sql
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i ++ ) {
                // 3 填充占位符
                ps.setObject(i + 1, args[i]);
            }
            // 4 执行sql语句，返回结果集
            rs = ps.executeQuery();
            // 获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            // 通过ResultSetMetaData获得列数
            int columnCnt = rsmd.getColumnCount();
            if (rs.next()) {
                Customer cust = new Customer();
                // 5 处理结果集，返回结果对象
                // 处理结果集的一行中的每一列
                for (int i = 0; i < columnCnt; i ++ ) {
                    // 获取每一列的值(在resultSet中)
                    Object columnValue = rs.getObject(i + 1);
                    // 获取每个列的列名columnName（在resultSetMetaData中）
//                    String columnName = rsmd.getColumnName(i + 1);
                    String columnName = rsmd.getColumnLabel(i + 1);
                    // 给cust的的columnName赋值为columnVAlue，通过反射
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(cust, columnValue);
                }
                return cust;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 资源关闭
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

    // 针对Customers表的查询操作
    @Test
    public void testQuery1() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            //1 获得连接
            conn = JDBCUtils.getConnection();
            // 2 预编译sql
            String sql = "select id, name, email, birth from customers where id = ?";
            ps = conn.prepareStatement(sql);
            // 3 设置占位符
            ps.setObject(1, 1);
            // 4 执行sql并且返回结果集
            resultSet = ps.executeQuery();
            // 5 处理结果集
            if (resultSet.next()) { // 判断结果集是否有数据，true就下移，
                // 获取各个字段
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                // 将查询的信息封装为一个对象
                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6 关闭资源
            JDBCUtils.closeResource(conn, ps, resultSet);
        }
    }
}
