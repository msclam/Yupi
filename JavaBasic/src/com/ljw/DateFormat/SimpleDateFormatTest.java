package com.ljw.DateFormat;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lanjuwen
 * @create 2021-11-18  0:13
 */
public class SimpleDateFormatTest {
    /**
     * SimpleDateFormat对Date进行格式化（日期->字符串）和解析（字符串->日期）
     */
    @Test
    public void test1() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
//        System.out.println(date);
        // 格式化
        String format = sdf.format(date);
        System.out.println(format);

        // 解析
        String str = "2019/12/18 上午11:58";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str1 = "2021-11-18 0:23:0";
        Date date2 = sdf1.parse(str1);
        System.out.println(date2);
    }

    @Test
    public void test2() throws ParseException {
        // 转化为java.sql.Date
        String str = "2021-11-18";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        java.sql.Date birth = new java.sql.Date(date.getTime());
        System.out.println(birth);
    }
}
