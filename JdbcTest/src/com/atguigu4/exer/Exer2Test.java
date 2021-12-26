package com.atguigu4.exer;

import com.atguigu3.bean.Student;
import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lanjuwen
 * @create 2021-12-26  0:38
 */
public class Exer2Test {
    //case 1 向examstudent增加一个记录
    @Test
    public void testInsert() {
        Scanner s = new Scanner(System.in);
        System.out.println("type:");
        int type = s.nextInt();
        System.out.println("IDCard:");
        String idCard = s.next();
        System.out.println("examCard:");
        String examCard = s.next();
        System.out.println("StudentName:");
        String studentName = s.next();
        System.out.println("Location:");
        String location = s.next();
        System.out.println("Grade:");
        int grade = s.nextInt();

        String sql = "insert into examstudent(type,idcard,examcard,studentname,location,grade)"
                + "values(?,?,?,?,?,?)";

        update(sql, type, idCard, examCard, studentName, location, grade);
        System.out.println("录入成功！");
    }

    @Test
    // case 2 根据身份证号或者准考证号查询成绩信息
    public void testQuery() {
        System.out.println("请选择您要输入的类型：\na:准考证号\nb:身份证号:");
        Scanner s = new Scanner(System.in);
        String type = s.next();
        if ("a".equalsIgnoreCase(type)) {
            System.out.println("输入准考证");
            String examCard = s.next();
            String sql = "select Type type,IDCard IDCard,ExamCard examCard,Location location,StudentName studentName,Grade grade from examstudent"
                    + " where examCard = ?";
            List<Student> list = getForList(Student.class, sql, examCard);
            for (Student stu : list) {
                if (stu != null) {
                    System.out.println(stu);
                } else {
                    System.out.println("输入准考证号有误");
                }
            }
        } else if ("b".equalsIgnoreCase(type)) {
            System.out.println("输入身份证");
            String IDCard = s.next();
            String sql = "select Type type,IDCard IDCard,ExamCard examCard,Location location,StudentName studentName,Grade grade from examstudent"
                    + " where IDCard = ?";
            List<Student> list = getForList(Student.class, sql, IDCard);
            for (Student stu : list) {
                if (stu != null) {
                    System.out.println(stu);
                } else {
                    System.out.println("输入身份证号有误");
                }
            }
        } else {
            System.out.println("输入有错误");
        }
    }

    @Test
    // case 3 删除指定的学生信息
    public void testDelete() {
        System.out.println("输入学生的考号");
        Scanner sc = new Scanner(System.in);
        String examCard = sc.next();

        // 查询指定准考证号的学生
        String sql = "delete from examstudent where examcard = ?";
        boolean deleteFlag = delete(sql, examCard);
        if (deleteFlag) {
            System.out.println("删除成功");
        } else {
            System.out.println("查无此人");
        }
    }

    // 通用的增删改操作
    public static void update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            ps.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
    }

    // 不同表的通用查询
    public <T> List<T> getForList(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCnt = rsmd.getColumnCount();
            ArrayList<T> list = new ArrayList<>();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCnt; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

    // 增加返回值的删除，本质上和update一样
    public boolean delete(String sql, Object...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i ++ ) {
                ps.setObject(i + 1, args[i]);
            }
            int cnt = ps.executeUpdate();
            if (cnt > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps);
        }
        return false;
    }
}
