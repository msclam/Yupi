package com.ljw.IOStream;

import java.util.Arrays;

/**
 * @author lanjuwen
 * @create 2021-12-02  1:07
 */
public class TransferStream {
//    @Test
//    public void test() throws IOException {
////        FileInputStream fis = new FileInputStream("abc.txt");
////        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
////
////        int len = 0;
////        char[] buffer = new char[1024];
////        while ((len = isr.read(buffer)) != -1) {
////            String str = new String(buffer, 0, len);
////            System.out.println(str);
////        }
////        isr.close();
//
//        String str = "124";
//        System.out.println("0" + str);
//    }

    public static void main(String[] args) {
        String s = "123";
        System.out.println();
        s = "0" + s;
        System.out.println(s);
//        System.out.println("0" + s);

    }
}
