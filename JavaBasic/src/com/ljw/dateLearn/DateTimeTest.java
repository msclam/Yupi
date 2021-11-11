package com.ljw.dateLearn;

import org.junit.Test;

import java.util.Date;

public class DateTimeTest {
    @Test
    public void test() {
        long time = System.currentTimeMillis();
        System.out.println(time); // 返回距离1970年1月1日0时0分0秒的毫秒数（时间差）
    }

    @Test
    public void test2() {
        /**
         * 两个构造器
         *  new Date()
         *  new Date(xxxL)
         *
         * 两个方法：
         *  toString() 显示当前年月日时分秒
         *  getTime()  获取当前对象对应的毫秒数
         */

        // 构造器: Date()
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        Date date2 = new Date(1636631368706L);
        System.out.println(date2);

        java.sql.Date date3 = new java.sql.Date(1636631368706L);
        System.out.println(date3);

        Date date = new Date();
        java.sql.Date date4 = new java.sql.Date(date.getTime());
    }
}
