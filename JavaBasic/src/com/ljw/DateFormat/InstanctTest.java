package com.ljw.DateFormat;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @author lanjuwen
 * @create 2021-11-18  10:06
 */
public class InstanctTest {
    @Test
    public void test() {
        Instant instant = Instant.now();
        System.out.println(instant);

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        long milli = instant.toEpochMilli();
        System.out.println(milli);

        Instant instant1 = Instant.ofEpochMilli(1637201451869L);
        System.out.println(instant1);
    }
}
