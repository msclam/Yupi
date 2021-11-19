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
            System.out.println(it.next());
        }
    }
}
