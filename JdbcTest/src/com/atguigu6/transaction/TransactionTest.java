package com.atguigu6.transaction;

import com.atguigu3.bean.User;
import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author lanjuwen
 * @create 2021-12-26  17:15
 */
public class TransactionTest {
    /*
    * 事务：一组逻辑操作单元（DML），使得数据从一种状态变为另一种状态
    * 要么commit, 要么就rollback
    * DDL一旦执行，自动提交
    * DML一旦执行，自动提交（可以设置autocommit = false关闭）
    * 默认关闭时，会自动提交
    * */
    /**************考虑事务的增删改************/
    @Test
    public void testUpdateTransaction() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            // 1 关闭自动提交
            conn.setAutoCommit(false);

            String sql1 = "update user_table set balance = balance - 100 where user = ?";
            update(conn, sql1, "AA");

            // 模拟故障网络
            System.out.println(10 / 0);

            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            update(conn, sql2, "BB");

            System.out.println("success");

            // 2 提交
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 3 回滚数据
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                // 修改其为自动提交数据
                // 针对数据库连接池的问题
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(conn, null);
        }
    }

    // 针对不同表的通用的增删改操作--version2.0
    public int update(Connection conn, String sql, Object...args) {
        PreparedStatement ps = null;
        try {
            // 1 获得数据库的连接
//            conn = JDBCUtils.getConnection();
            //2 预编译sql语句， 返回prepareStatement对象
            ps = conn.prepareStatement(sql);
            // 3 填充占位符
            for (int i = 0; i < args.length; i ++ ) {
                ps.setObject(i + 1, args[i]);
            }
            // 4 执行
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5 资源关闭
            JDBCUtils.closeResource(null, ps);
        }
        return 0;
    }

    /**************未考虑事务的增删改************/
    @Test
    /*
    * 针对user_table
    * AA转账BB 100
    * update user_table set balance = balance - 100 where user = 'AA'
    * update user_table set balance = balance + 100 where user = 'BB'
    * */
    public void testUpdate() {
        String sql1 = "update user_table set balance = balance - 100 where user = ?";
        update(sql1, "AA");

        // 模拟故障网络
        System.out.println(10 / 0);

        String sql2 = "update user_table set balance = balance + 100 where user = ?";
        update(sql2, "BB");

        System.out.println("success");
    }

    // 针对不同表的通用的增删改操作--version1.0
    public int update(String sql, Object...args) {
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
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5 资源关闭
            JDBCUtils.closeResource(conn, ps);
        }
        return 0;
    }

    /**********************考虑事务的通用查询 version 2.0**************************/
    @Test
    public void testTransactionSelect() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        // 获取当前连接的隔离级别
        System.out.println(conn.getTransactionIsolation());
        // 设置连接隔离级别
        conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        // 取消自动提交数据
        conn.setAutoCommit(false);
        String sql = "select user, password, balance from user_table where user = ?";
        User user = getInstanc(conn, User.class, sql, "CC");
        System.out.println(user);
    }

    @Test
    public void testTransactionUpdate() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        // 取消自动提交数据
        conn.setAutoCommit(false);
        String sql = "update user_table set balance = ? where user = ?";
        update(conn, sql, 5000, "CC");
        Thread.sleep(5000);
        System.out.println("修改结束");
        conn.commit();
    }

    // 针对不同表的通用查询(返回一条记录)
    public <T> T getInstanc(Connection conn, Class<T> clazz, String sql, Object...args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1 获取连接
//            conn = JDBCUtils.getConnection();

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
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }

    /****************未考虑事务的查询********************/
    // 针对不同表的通用查询(返回一条记录) v1.0
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
