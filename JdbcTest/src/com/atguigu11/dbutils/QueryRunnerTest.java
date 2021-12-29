package com.atguigu11.dbutils;

import com.atguigu3.bean.Customer;
import com.atguigu3.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QueryRunnerTest {
    // dbutils封装增删改查的操作
    @Test
    public void testInsert() {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();  // // 使用dbutils进行增删查改
            conn = JDBCUtils.getConnection3();  // 使用druid数据库连接池获得数据库连接
            String sql = "insert into customers(name, email, birth) values(?, ?, ?)";
            int insertCnt = runner.update(conn, sql, "abc", "abc@qq.com", "1997-01-01");
            System.out.println("添加了" + insertCnt + "条记录");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource1(conn, null); // 使用dbutils工具类关闭资源
//            JDBCUtils.closeResource(conn, null);
        }
    }

    /*
    * BeanHandler 是resultSetHandler接口的实现类，用于封装表中的一条记录
    * */
    @Test
    public void testQuery1() throws Exception {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "select id, name, email, birth from customers where id = ?";
            BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
            Customer cust = runner.query(conn, sql, handler, 23);
            System.out.println(cust);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            JDBCUtils.closeResource(conn, null);
            JDBCUtils.closeResource1(conn, null);
        }
    }

    /*
     * BeanListHandler 是resultSetHandler接口的实现类，用于封装表中的多条记录
     * */
    @Test
    public void testQuery2() throws Exception {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "select id, name, email, birth from customers where id < ?";
            BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
            List<Customer> list = runner.query(conn, sql, handler, 23);
            Iterator<Customer> it = list.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    /*
     * MapHandler 是resultSetHandler接口的实现类，用于封装表中的一条记录（将字段以键值对方式返回）
     * 将字段和字段的值作为map的key和value返回
     * */
    @Test
    public void testQuery3() throws Exception {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "select id, name, email, birth from customers where id = ?";
            MapHandler handler = new MapHandler();
            Map<String, Object> map = runner.query(conn, sql, handler, 23);
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    /*
     * MapListHandler 是resultSetHandler接口的实现类，用于封装表中的多条记录(键值对作为list的值)
     * 将字段和字段的值作为map的key和value返回，将map添加到list中
     * */
    @Test
    public void testQuery4() throws Exception {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "select id, name, email, birth from customers where id < ?";
            MapListHandler handler = new MapListHandler();
            List<Map<String, Object>> list = runner.query(conn, sql, handler, 23);
            Iterator<Map<String, Object>> it = list.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    /**
     * ScalarHandler 接受特殊值的查询查询
     * @throws Exception
     */
    @Test
    public void testQuery5() throws Exception {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "select count(*) from customers";
            ScalarHandler handler = new ScalarHandler();
            Long count = (Long) runner.query(conn, sql, handler);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Test
    public void testQuery6() throws Exception {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "select max(birth) from customers";
            ScalarHandler handler = new ScalarHandler();
            Date maxBirth = (Date) runner.query(conn, sql, handler);
            System.out.println(maxBirth);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    /**
     * 自定义ResultSetHandler的实现类
     * @throws Exception
     */
    @Test
    public void testQuery7() throws Exception {
        Connection conn = null;
        try {
            QueryRunner runner = new QueryRunner();
            conn = JDBCUtils.getConnection3();
            String sql = "select id, name, email, birth from customers where id = ?";
            ResultSetHandler<Customer> handler = new ResultSetHandler<Customer>() {
                @Override
                public Customer handle(ResultSet rs) throws SQLException {
                    if (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String email = rs.getString("email");
                        Date birth = rs.getDate("birth");
                        Customer customer = new Customer(id, name, email, birth);
                        return customer;
                    }
                    return null;
                }
            };
            Customer cust = runner.query(conn, sql, handler, 23);
            System.out.println(cust);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }
}
