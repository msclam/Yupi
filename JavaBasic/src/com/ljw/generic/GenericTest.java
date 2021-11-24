package com.ljw.generic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GenericTest {
    @Test
    public void test() {
        Map<Character, Integer> map = new HashMap<>();
        map.values();
        map.keySet();
        map.entrySet();
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> e = iterator.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
