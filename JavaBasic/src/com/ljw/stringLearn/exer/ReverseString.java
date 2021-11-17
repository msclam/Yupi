package com.ljw.stringLearn.exer;

import org.junit.Test;

/**
 * @author lanjuwen
 * @create 2021-11-17  20:23
 */
public class ReverseString {
    public String reverseStr(String str, int l, int r) {
        if (str != null) {
            char[] chars = str.toCharArray();
            for (int i = l, j = r; i < j; i++, j--) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
            return new String(chars);
        }
        return null;
    }

    public void reverseString(StringBuilder sb, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, tmp);
        }
    }

    @Test
    public void reverseStrTest() {
        String str = "abcdefg";
        String s = reverseStr(str, 2, 5);
        System.out.println(s);
        System.out.println(str);
    }

    @Test
    public void reverseStringBuildTest() {
        String str = "abcdefg";
        StringBuilder strb = new StringBuilder(str);
        reverseString(strb, 2, 5);
        System.out.println(strb.toString());
    }
}
