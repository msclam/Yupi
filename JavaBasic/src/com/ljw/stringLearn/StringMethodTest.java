package com.ljw.stringLearn;

import org.junit.Test;

public class StringMethodTest {
    @Test
    public void test4() {
        String str1 = "abcd";
        String str2 = str1.replace("ab", "zj");
        System.out.println(str2);

        String str = "123hello456world65756mysql12431";
        String str3 = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(str3);

        str = "123456";
        boolean matches = str.matches("\\d+");
        System.out.println(matches);

        str = "0571-45342899";
        matches = str.matches("0571-\\d{7,8}");
        System.out.println(matches);

        str = "hello|world|java|abc";
//        String[] strs = str.split("\\|", 2);
        String[] strs = str.split("\\|");
        for (String s : strs) {
            System.out.println(s);
        }
    }

    @Test
    public void test3() {
        String s = "aabcdefg";
        boolean b1 = s.startsWith("abc");
        boolean b2 = s.endsWith("fg");
        boolean b3 = s.startsWith("cde", 2);
        System.out.println(b1 + " " + b2 + " " + b3);
        System.out.println(s.contains("de"));

        System.out.println(s.indexOf("a"));
        System.out.println(s.lastIndexOf("a"));
    }

    @Test
    public void test2() {
        String s1 = "HelloWorld";
        String s2 = "helloworld";

        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = s3.concat("def"); // 等价于"+"
        System.out.println(s4);

        String s5 = "abc";
        String s6 = new String("abd");
        System.out.println(s5.compareTo(s6));  // 比较字符串的大小，涉及到字符串的排序
        
        String s7 = "abcdef";
        String s8 = s7.substring(2);
        System.out.println(s8);

        String s9 = s7.substring(2, 4); //[l, r)
        System.out.println(s9);
//        (int)(Math.random() * (b - a + 1) + a)
    }

    @Test
    public void test1() {
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.isEmpty());

        String s2 = s1.toLowerCase();
        System.out.println(s1); //本来的字符串不变
        System.out.println(s2);

        String s3 = "  he  llo  world  ";
        String s4 = s3.trim(); // 去除首尾空格
        System.out.println("---" + s3 + "---");
        System.out.println("---" + s4 + "---");

    }
}
