package com.ljw.Collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListFor {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // Iterator
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // for增强
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        // for
        for (int i = 0; i < list.size(); i ++ ) {
            System.out.print(list.get(i) + " ");
        }

    }
}
