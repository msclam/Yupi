package com.atguigu7.daoFinal;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao<T> {
    private QueryRunner queryRunner = new QueryRunner();
    // 定义一个变量来接受泛型类型
    private Class<T> type;

    // 获取T的class对象，获取泛型的类型，泛型在子类被继承时才去确定
    public BaseDao() {
        Class clazz = this.getClass();
        ParameterizedType genericSuperclass = (ParameterizedType)clazz.getGenericSuperclass();// 当前类的父类
        // 获取泛型类型数组
        Type[] types = genericSuperclass.getActualTypeArguments();
        // 获取具体的泛型类型
        this.type = (Class<T>) types[0];
    }

    /**
     * 通用的增删改操作
     * @param conn
     * @param sql
     * @param args
     * @return
     */
    public int update(Connection conn, String sql, Object...args) {
        int cnt = 0;
        try {
            cnt = queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt;
    }

    /**
     * 返回一个查询结果对象
     * @param conn
     * @param sql
     * @param args
     * @return
     */
    public T getBean(Connection conn, String sql, Object...args) {
        T t = null;
        try {
            t = queryRunner.query(conn, sql, new BeanHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 返回一个结果列表
      * @param conn
     * @param sql
     * @param args
     * @return
     */
    public List<T> getBeanList(Connection conn, String sql, Object...args) {
        List<T> list = null;
        try {
            list = queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 返回特殊的查询结果
     * @param conn
     * @param sql
     * @param args
     * @return
     */
    public Object getValue(Connection conn, String sql, Object...args) {
        Object result = null;
        try {
            result = queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
