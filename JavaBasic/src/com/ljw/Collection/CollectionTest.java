package com.ljw.Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        System.out.println(coll.isEmpty());
        // add
        coll.add(123);
        coll.add(456);
        coll.add(false);
        coll.add(456);
        coll.add(new Person());

        System.out.println(coll);
        // size
        System.out.println(coll.size());

        // addAll
        Collection coll1 = new ArrayList();
        coll1.add("9090");
        coll1.add("1024");
        coll.addAll(coll1);
        System.out.println(coll);

        // isEmpty()
        System.out.println(coll.isEmpty());

        // clear()
        coll.clear();
        System.out.println(coll.isEmpty()); // true

        // contains调用equals比较内容，所以必须重写equals
        boolean contains = coll.contains(123);
        System.out.println(contains);
        coll.add(new String("tom"));
        coll.add(new Person("tom", 12));
        System.out.println(coll.contains(new String("tom"))); // 调用equals方法  true
        System.out.println(coll.contains(new Person("tom", 12)));  // 没有重写equals就是false,如果重写就是true

        // containsAll
        Collection coll2 = Arrays.asList("9090", "1024");
        System.out.println(coll1.containsAll(coll2));
    }

    @Test
    public void test2() {
        // remove调用的是equals方法
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("abc", 123));
        coll.add(new String("Tom"));
        coll.remove(123);
        coll.remove(new Person("abc", 123));
        System.out.println(coll);

        Collection coll1 = Arrays.asList(123, 789, 456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3() {
        // retainAll求交集，并修改原来的集合
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("abc", 123));
        coll.add(new String("tom"));
        coll.add(false);

        Collection coll1 = Arrays.asList(123, 456);
        coll.retainAll(coll1);
        System.out.println(coll);

        // equals 按照顺序相比较相等（集合+集合中的元素）
        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test5() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("abc", 123));
        coll.add(new String("tom"));
        coll.add(false);

        System.out.println(coll.hashCode());  // 返回当前对象的hash值

        // 集合->数组
        Object[] objects = coll.toArray();

        // 数组->集合
        List<String> strings = Arrays.asList(new String[]{"123", "456", "789"});
        System.out.println(strings);

        List<Integer> integers = Arrays.asList(new Integer[]{123, 456});
//        List<int[]> ints = Arrays.asList(new int[]{123, 456});
        System.out.println(integers);

        String[] strs = new String[]{"abc", "def"};  // 数组
        System.out.println(Arrays.toString(strs));
    }
}
