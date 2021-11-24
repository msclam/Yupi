package com.ljw.Collection.MapTest;

import org.junit.Test;

import java.util.*;

/**
 * @author lanjuwen
 * @create 2021-11-21  17:07
 */
public class MapTest {
    @Test
    public void test() {
        Map map = new HashMap();
        map.put(null, null);

        Map map1 = new Hashtable();
        map.put(null, null);
    }

    @Test
    // 增删改查
    public void test2() {
        Map map = new HashMap();
        //添加
        map.put("AA", 123);
        map.put("BB", 56);
        //修改
        map.put("AA", 87);
        map.put(45, 123);

        Map map1 = new HashMap();
        map1.put("CC", 123);
        map1.put("DD", 123);

        map.putAll(map1);
        System.out.println(map);

        map.remove("CC");
        System.out.println(map);

        map.clear();
        System.out.println(map.size());

        System.out.println(map.get(45));

        boolean isExist = map.containsKey(45);
        System.out.println(isExist);

        isExist = map.containsValue(87);
        System.out.println(isExist);
    }

    @Test
    // 遍历
    public void test3() {
        Map map = new HashMap();
        //添加
        map.put("AA", 123);
        map.put("BB", 56);
        //修改
        map.put("AA", 87);
        map.put(45, 123);

        Set set = map.keySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();
        Collection values = map.values();
        for (Object obj : values) {
            System.out.println(obj);
        }

        System.out.println();

//        for (Map.Entry<String, String> entry : map.entrySet()) {
//
//        }
        Set set1 = map.entrySet();
        Iterator iterator = set1.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        Map<Character, Integer> mp = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    @Test
    // 自然排序
    public void test4() {
        // TreeMap 添加key-value key是同一个类创建的对象
        // key要进行排序：自然排序和定制排序
        TreeMap map = new TreeMap();
        User u1 = new User("Tom", 23);
        User u2 = new User("Jerry", 32);
        User u3 = new User("Jack", 20);
        User u4 = new User("Rose", 18);

        map.put(u1, 98);
        map.put(u2, 89);
        map.put(u3, 76);
        map.put(u4, 100);

        Set set = map.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    @Test
    public void test5() {
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                } else {
                    throw new RuntimeException();
                }
            }
        });
    }

    @Test
    public void test6() {
        Map<String, String> map = new HashMap<>();
        // 一
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        // 二
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
