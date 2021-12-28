package com.atguigu7.daoEvolution;

import com.atguigu3.util.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lanjuwen
 * @create 2021-12-26  22:36
 */
public abstract class BaseDao<T> {
    private Class<T> clazz = null;

    /* ！为了获取BaseDao的子类继承父类中泛型 ！*/ {  // 为了避免每个实现子列写一份，所以写在父类中，相当于父类this
        // 实际上new子类对象时是使用子类的this
        // 当前类->带泛型的父类
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parmType = (ParameterizedType) genericSuperclass;
        Type[] types = parmType.getActualTypeArguments();// 获取父类的泛型参数列表
        clazz = (Class<T>) types[0]; // 获取泛型的第一个参数
    }

    // DAO data access object 数据访问对象
    // 封装针对数据表的通用操作

    // 1 针对不同表的通用的增删改操作--version2.0(考虑事务)
    // 为了保证同一个事务，把connection传进来
    public int update(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        try {
            // 1 获得数据库的连接
//            conn = JDBCUtils.getConnection();
            //2 预编译sql语句， 返回prepareStatement对象
            ps = conn.prepareStatement(sql);
            // 3 填充占位符
            for (int i = 0; i < args.length; i++) {
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

    //2  针对不同表的通用查询(返回一条记录) （考虑事务） version 2.0
    public T getInstance(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1 获取连接
//            conn = JDBCUtils.getConnection();

            // 2 预编译sql
            ps = conn.prepareStatement(sql);
            // 3 填写占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            // 4 执行
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCnt = rsmd.getColumnCount();
            // 5 处理结果
            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCnt; i++) {
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

    // 3 不同表的通用查询（返回多个记录的集合） 考虑事务（version 2.0）
    public List<T> getForList(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1 获取连接
//            conn = JDBCUtils.getConnection();

            // 2 预编译sql
            ps = conn.prepareStatement(sql);
            // 3 填写占位符
            for (int i = 0; i < args.length; i++) {
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
                for (int i = 0; i < columnCnt; i++) {
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
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }

    // 用于查询特殊值的通用方法
    public <E> E getValue(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            if (rs.next()) {
                return (E) rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }
}
