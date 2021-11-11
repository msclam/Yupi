package com.ljw.stringLearn;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringPackageCLass {
    @Test
    public void test1() {
        String s = "123"; // 在常量池
        int num = Integer.parseInt(s);
        System.out.println(num);

        String str = String.valueOf("123");
        String str2 = num + "";  // 在堆中，因为有变量的参与
        System.out.println(str);

        System.out.println(str2 == s);
    }

    @Test
    public void test2() {
        String s = "abc123";
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i ++ ) {
            System.out.println(ch[i]);
        }

        char[] chars = new char[]{'a', 'b', 'c'};
        String str = new String(chars);
        System.out.println(str);
    }

    @Test
    public void test3() throws UnsupportedEncodingException {
        char[] chars = new char[] {'a', 'b', 'c', 'd', 'e', 'f'};
        System.out.println(chars);
        System.out.println(Arrays.toString(chars));

        String s = "abc123中国";
        // 字符串-> 字节 （编码）
        byte[] bytes = s.getBytes();
        System.out.println(Arrays.toString(bytes));

        byte[] bytes1 = s.getBytes("gbk");
        System.out.println(Arrays.toString(bytes1));

        // 字节 -> 字符串  （解码）
        String tmp = new String(bytes);
        System.out.println(tmp);
        String tmp1 = new String(bytes1, "gbk");
        System.out.println(tmp1);
    }
}
