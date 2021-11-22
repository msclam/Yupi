package com.ljw.Collection.SetTest;

import org.junit.Test;

import java.util.*;

/**
 * @author lanjuwen
 * @create 2021-11-20  10:24
 */
public class SetTestCase {
    @Test
    public void test() {
        // 无序性(不等于随机性) -> hashSet底层数组按照hascode来放置对象
        // 和不可重复性 -> 需要重写equals和hashCode方法
//        Set set = new HashSet<>();
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom", 12));
        set.add(129);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        // TreeSet添加的都是相同类型的数据
        TreeSet set = new TreeSet();
//        set.add(34);
//        set.add(56);
//        set.add(78);

        set.add(new Person("Tom", 12));
        set.add(new Person("Jerry", 32));
        set.add(new Person("Jim", 2));
        set.add(new Person("Mike", 65));
        set.add(new Person("Jack", 32));
        set.add(new Person("Jack", 56));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3() {
        Comparator cmp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // 按照年龄从小到大
                if (o1 instanceof Person && o2 instanceof  Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(), p2.getAge());
                } else {
                    throw new RuntimeException("输入的数据不匹配");
                }
            }
        };
        TreeSet set = new TreeSet(cmp);
        set.add(new Person("Tom", 12));
        set.add(new Person("Jerry", 32));
        set.add(new Person("Jim", 2));
        set.add(new Person("Mike", 65));
        set.add(new Person("Jack", 32));
        set.add(new Person("Jack", 56));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
