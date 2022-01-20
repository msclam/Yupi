package com.ljw.Test;

/**
 * @author lanjuwen
 * @create 2021-10-17  17:20
 */
public class ForTest {
    public static void main(String[] args) {
//        for (int i = 1; i <= 150; i ++ ) {
//            System.out.print(i + " ");
//            if (i % 3 == 0) {
//                System.out.print("foo ");
//            }
//            if (i % 5 == 0) {
//                System.out.print("boo ");
//            }
//            if (i % 7 == 0) {
//                System.out.print("biz ");
//            }
//            System.out.println();
//        }

//        Stack<Integer> st = new Stack<>();
//        st.push(123);
//        st.push(12);
//        System.out.println(st.pop());
//        int[][] f = new int[10][10];
//        for (int[] arr : f) {
//            Arrays.fill(arr, 10);
//        }
//        for (int[] i : f) {
//            for (int j : i) {
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }

//        StringBuilder str = new StringBuilder();
//        str.append("123");
//        str.deleteCharAt(str.length() - 1);
//        System.out.println(str);

//        Queue<Integer> queue = new LinkedList<>();
//
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        System.out.println(queue.peek());
////        queue.remove();
//
//        while (!queue.isEmpty()) {
//            System.out.println(queue.poll());
//        }

        String s = "  hello world!   ";
        String[] strs = s.split("\\s+");
        System.out.println("====");
        for (String str : strs) {
            System.out.println(str);
        }
        System.out.println("====");
        System.out.println(strs.length);
        System.out.println(strs[0] + " " + strs[0].length());
        System.out.println(strs[1] + " " + strs[1].length());
        System.out.println(strs[2] + " " + strs[2].length());
    }
}
