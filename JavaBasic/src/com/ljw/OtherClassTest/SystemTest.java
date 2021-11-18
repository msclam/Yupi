package com.ljw.OtherClassTest;

import org.junit.Test;

/**
 * @author lanjuwen
 * @create 2021-11-18  12:36
 */
public class SystemTest {
    @Test
    public void test() {
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("os.home"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
    }
}
