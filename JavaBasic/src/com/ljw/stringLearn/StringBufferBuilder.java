package com.ljw.stringLearn;

import org.junit.Test;

public class StringBufferBuilder {
    /**
     * 相同点：底层使用char[]存储
     * String 不可变的字符序列
     * StringBuffer 线程安全，效率低 （出现共享数据）
     * StringBuilder 线程不安全，效率高 jdk5.0出现
     * @param
     */
    @Test
    public void test() {
        StringBuffer s = new StringBuffer("abc");
        s.setCharAt(0, '1');
        System.out.println(s);

        StringBuffer strb = new StringBuffer();
        strb.append("213");
        strb.setCharAt(1, 'c');;
        System.out.println(strb);
    }

    @Test
    public void test2() {
        StringBuffer strb = new StringBuffer("abc");
        strb.append(1);
        strb.append('1');
        System.out.println(strb);
//        strb.delete(2, 4);
//        strb.replace(2, 4, "hello");
//        strb.insert(2, false);
//        strb.reverse();
        strb.setCharAt(0, 'z');
        String s = strb.substring(2, 4);
        System.out.println(strb);
        System.out.println(s);

        /**
         * 增：append(x)
         * 删：delete(l, r)
         * 查：charAt(index)
         * 改：setCharAr(index, x) / replace(l, r, xxx)
         * 插：insert(index, x)
         * 长度：length()
         * 遍历：for charAr(index) / toString()
         */

    }

    @Test
    public void test3() {
        long start = 0L;
        long end = 0L;
        String s1 = "";
        StringBuffer s2 = new StringBuffer("");
        StringBuilder s3 = new StringBuilder("");

        start = System.currentTimeMillis();
        for (int i = 0; i < 200000; i ++ ) {
            s1 += i;
        }
        end = System.currentTimeMillis();
        System.out.println("String: " + (end - start));


        start = System.currentTimeMillis();
        for (int i = 0; i < 200000; i ++ ) {
            s2.append(String.valueOf(i));
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 200000; i ++ ) {
            s3.append(String.valueOf(i));
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder: " + (end - start));
    }
}
