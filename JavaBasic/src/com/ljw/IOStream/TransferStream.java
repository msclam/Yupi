package com.ljw.IOStream;

import org.junit.Test;

import java.io.*;

/**
 * @author lanjuwen
 * @create 2021-12-02  1:07
 */
public class TransferStream {
    @Test
    public void test() throws IOException {
        FileInputStream fis = new FileInputStream("abc.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

        int len = 0;
        char[] buffer = new char[1024];
        while ((len = isr.read(buffer)) != -1) {
            String str = new String(buffer, 0, len);
            System.out.println(str);
        }
        isr.close();

        String str = "124";
        System.out.println("0" + str);
    }

    @Test
    public void test2() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            File file1 = new File("abcb");
            File file2 = new File("bca");

            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            isr = new InputStreamReader(fis, "utf-8");
            osw = new OutputStreamWriter(fos, "gbk");


            char[] buffer = new char[1024];
            int len;
            while ((len = isr.read(buffer)) != -1) {
                osw.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    public static void main(String[] args) {
//        String s = "123";
//        System.out.println();
//        s = "0" + s;
//        System.out.println(s);
////        System.out.println("0" + s);
//
//    }

    @Test
    public void test3() {

    }
}
