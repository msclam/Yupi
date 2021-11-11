package com.ljw.stringLearn;

import org.junit.Test;

public class StringTest {
    @Test
    public void test6() {
        /**
         * 常量和常量拼接结果在常量池，且常量池中不会存在相同内容的常量
         * 只要有一个是变量，结果就在堆里
         * 拼接结果调用intern()，返回值在常量池中
         */
        String s1 = "123456";
        String s2 = "123";
        String s3 = s2 + "456";
        System.out.println(s1 == s3);  // false

        final String s4 = "123";
        String s5 = s4 + "456";
        System.out.println(s1 == s5);  //true
    }

    @Test
    public void test5() {
        /**
         * String -> char[]   toCharArray()
         * char[] -> String   调用String的构造方法
         */

        String str = "abcd";
        for (int i = 0; i < str.length(); i ++ ) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();

        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i ++ ) {
            System.out.print(charArray[i] + " ");
        }
        System.out.println();

        char[] ch = new char[]{'a', 'b', 'c', 'd'};
        String str1 = new String(ch);
        System.out.println(ch);

        String s = "abc123"; // 转化为 a21cb3
        char[] array = s.toCharArray();
        reverse(array, 1, 4);
        str1 = new String(array);
        System.out.println(str1);
    }
    public static void reverse(char[] A, int l, int r) {
        for (int i = 0; i < (r - l + 1) / 2; i ++ ) {
            char c = A[l + i];
            A[l + i] = A[r - i];
            A[r - i] = c;
        }
    }

    @Test
    public void test4() {
        /**
         * String和基本数据类型、包装类之间的转换
         * String -> 包装类、基本数据类型   调用包装类的静态方法parseXxx(str)
         * 包装类、基本数据类型  -> String  调用String重载的valueOf(xxx)
         */
        String str1 = "123";
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num);
        String str3 = num + "";

        System.out.println(str1 == str3); // false
    }

    /**
     * 常量和常量的拼接结果在常量池中，且常量池不会存在相同内容的常量
     * 只要其中有一个是变量，结果就在堆中
     * 如果拼接的结果调用intern()方法，返回值就在常量池中
     */
    @Test
    public void test3() {
        String s1 = "hello";
        String s2 = "world";
        String s3 = "hello" + "world";
        String s4 = s1 + "world";
        String s5 = s1 + s2;
        String s6 = (s1 + s2).intern();
        System.out.println(s3 == s6); // true
        System.out.println(s3 == s4); // false
        System.out.println(s3 == s5); // false
        System.out.println(s4 == s5); // false
    }


    /**
     * String的实例化方式
     * "" 字面量
     * new String()
     */
    @Test
    public void test2() {
        String s1 = "abc"; // 在字符串常量池
        String s2 = new String("abc");  // 在堆空间中
        System.out.println(s1 == s2);

        String s3 = "123";
        Person p1 = new Person("123");
        Person p2 = new Person("123");
        System.out.println(p1.name.equals(p2.name));  //比较内容 equals重写了
        System.out.println(p1.name == p2.name); // 比较地址值


        System.out.println(s3.hashCode()); // 48690
        System.out.println(p1.name.hashCode()); // 48690
    }

    /**
     * String为final不可被继承
     * String实现Serializable接口：表示字符支持序列化（IO流）
     *       实现Comparable接口：表示String可以比较大小
     *       final char[] value 用于存储字符后串数据（不可变的字符序列）
     * 字符串常量池不会存储相同内容的字符串
     */
    @Test
    public void test1() {
        String s1 = "abc";
        String s2 = "abc";

        System.out.println(s1 == s2);
        s1 = "123";
        System.out.println(s1);
        System.out.println(s2);

        s1 += "abc";
        System.out.println(s1);
        System.out.println(s2);

        String s3 = s1.replace('a', 'm');
        System.out.println(s3);
    }
}
