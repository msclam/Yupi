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

        StringBuilder str = new StringBuilder();
        str.append("123");
        str.deleteCharAt(str.length() - 1);
        System.out.println(str);
    }
}
