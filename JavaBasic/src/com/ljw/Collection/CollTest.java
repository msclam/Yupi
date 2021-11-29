package com.ljw.Collection;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class CollTest {
    @Test
    public void test() {
        Deque<Integer> q = new LinkedList<>();
//        q.add(1);
//        q.add(2);
//        q.add(3);

        System.out.println(q.peekFirst());

        Stack<Integer> st = new Stack<>();
    }
}
