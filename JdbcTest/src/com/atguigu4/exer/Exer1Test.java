package com.atguigu4.exer;

import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @author lanjuwen
 * @create 2021-12-26  0:19
 */
public class Exer1Test {
    @Test
    public void testInsert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入用户名");
        String name = sc.next();
        System.out.println("输入邮箱");
        String email = sc.next();
        System.out.println("输入生日"); // 1990=08-08
        String birthday = sc.next();

        String sql = "insert into customers(name, email, birth) values(?, ?, ?)";
        int insertCnt = update(sql, name, email, birthday);
        if (insertCnt > 0) {
            System.out.println("添加成功!");
        } else {
            System.out.println("添加失败!");
        }
    }

    // 通用的增删改操作
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
            // 如果是查询，有返回结果，返回true
            // 如果是增删改，则返回false
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5 资源关闭
            JDBCUtils.closeResource(conn, ps);
        }
        return 0;
    }
}
