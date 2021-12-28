package com.atguigu7.daoEvolution;

import com.atguigu3.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author lanjuwen
 * @create 2021-12-26  23:51
 */
/*
* 此接口用于规范针对customer表的常用操作
* */
public interface CustomerDao {
    /**
     * 将cust对象添加到数据库中
     * @param conn
     * @param cust
     */
    void insert(Connection conn, Customer cust);

    void deleteById(Connection conn, int id);

    /**
     * 针对内存中的cust对象，去修改数据表中指定的记录
     * @param conn
     * @param cust
     */
    void update(Connection conn, Customer cust);

    /**
     * 根据指定的id找到Customer
     * @param conn
     * @param id
     * @return
     */
    Customer getCustomerById(Connection conn, int id);

    /**
     * 查询所有记录
     * @param conn
     * @return
     */
    List<Customer> getAll(Connection conn);

    /***
     * 返回数据表中数据的条目数
     * @param conn
     * @return
     */
    Long getCount(Connection conn);

    /**
     * 返回表中最大的生日
     * @param conn
     * @return
     */
    Date getMaxBirth(Connection conn);
}
