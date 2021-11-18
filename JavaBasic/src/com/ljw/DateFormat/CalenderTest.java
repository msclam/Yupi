package com.ljw.DateFormat;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author lanjuwen
 * @create 2021-11-18  0:40
 */
public class CalenderTest {
    @Test
    public void test() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());

        // get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        // set()
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //add()
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.DAY_OF_MONTH, -3);

        //getTime()
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime()
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
