package com.ljw.stringLearn.exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author lanjuwen
 * @create 2021-11-17  21:00
 */
public class GetMaxSameString {
    public String getMaxSameString(String str1, String str2) {
        String maxStr = str1.length() >= str2.length() ? str1 : str2;
        String minStr = str1.length() < str2.length() ? str1 : str2;

        int n = minStr.length();
        for (int len = 0; len < n; len++) {
            for (int l = 0, r = n - len; r <= n; l++, r++) {
                String subStr = minStr.substring(l, r);
                if (maxStr.contains(subStr)) {
                    return subStr;
                }
            }
        }
        return null;
    }

    public String[] getMaxSameString1(String str1, String str2) {
        String maxStr = str1.length() >= str2.length() ? str1 : str2;
        String minStr = str1.length() < str2.length() ? str1 : str2;
        StringBuffer strb = new StringBuffer();
        int n = minStr.length();
        for (int len = 0; len < n; len++) {
            for (int l = 0, r = n - len; r <= n; l++, r++) {
                String subStr = minStr.substring(l, r);
                if (maxStr.contains(subStr)) {
                    strb.append(subStr + ",");
                }
            }
            if (strb.length() != 0) {
                break;
            }
        }
        String[] strings = strb.toString().replaceAll(",$", "").split("\\,");
        return strings;
    }

    @Test
    public void test() {
        String s = "abcdefgh";
        String s1 = "defabc";

        System.out.println(getMaxSameString(s, s1));
//        String[] strings = getMaxSameString1(s, s1);
//        for (String st : strings) {
//            System.out.println(st);
//        }
        System.out.println(Arrays.toString(getMaxSameString1(s, s1)));
    }
}
