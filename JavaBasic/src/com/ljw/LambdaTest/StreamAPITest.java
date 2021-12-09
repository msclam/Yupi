package com.ljw.LambdaTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StreamAPITest {
    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.stream();
    }
}
