package com.ljw.Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("abc", 123));
        coll.add(new String("Tom"));

        Iterator it = coll.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());  // 先下移，再取值
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i = 0; i < list.size(); i ++ ) {
            System.out.println(list.get(i));
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            if (num == 1) {
                iterator.remove();
            }
        }

        for (int i = 0; i < list.size(); i ++ ) {
            System.out.println(list.get(i));
        }

    }
}
