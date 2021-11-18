package com.ljw.DateFormat;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author lanjuwen
 * @create 2021-11-18  9:46
 */
public class LocalDateTimeTest {
    @Test
    public void test() {
        // now 当前的时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        // 设置时间
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 24, 13, 23, 29);
        System.out.println(localDateTime1);
        // 有偏移量
        Date date = new Date(2020 - 1900, 9 - 1, 8);
        System.out.println(date);

        // getXXX
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        // 体现不可变性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusMinutes(3);
        System.out.println(localDateTime4);
    }

    @Test
    public void test1() {
        // DateTimeFormatter
        // 格式化 日期->字符串
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);

        // 解析： 字符串->日期
        TemporalAccessor parse = formatter.parse("2021-11-18T02:10:51.869856400Z");
        System.out.println(parse);
    }
}
