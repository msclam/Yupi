package com.atguigu8.connectionPool.c3p0;

import com.atguigu3.bean.Customer;
//import com.atguigu3.util.JDBCUtils;
import com.atguigu7.daoEvolution.CustomerDaoImpl;
import com.atguigu8.connectionPool.c3p0.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerDaoImplTest {

    private com.atguigu7.daoEvolution.CustomerDaoImpl dao = new CustomerDaoImpl();
    @Test
    public void insert() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection1();
            Customer cust = new Customer(1, "yu", "yu@qq.com", new Date(3432534646L));
            dao.insert(conn, cust);
            System.out.println("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Test
    public void deleteById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection1();
            dao.deleteById(conn, 23);
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Test
    public void update() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection1();
            Customer cust = new Customer(22, "yuan", "yuan@126.com", new Date(3432534646L));
            dao.update(conn, cust);
            System.out.println("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Test
    public void getCustomerById() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection1();
            Customer cust = dao.getCustomerById(conn, 22);
            System.out.println(cust);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Test
    public void getAll() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection1();  // 测试c3p0连接池
            List<Customer> list = dao.getAll(conn);
            for (Customer cust : list) {
                System.out.println(cust);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Test
    public void getCount() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection1();
            Long count = dao.getCount(conn);
            System.out.println("表中的记录数目：" + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }

    @Test
    public void getMaxBirth() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection1();
            Date maxBirth = dao.getMaxBirth(conn);
            System.out.println("最大的生日是：" + maxBirth);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }
    }
}