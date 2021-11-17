package com.ljw.stringLearn.exer;

/**
 * @author lanjuwen
 * @create 2021-11-17  21:22
 */
public class IdeaDebug {
    public static void main(String[] args) {
        String str = null;
        StringBuffer strb = new StringBuffer();
        strb.append(str);

        System.out.println(strb.length());  //4

        System.out.println(strb);

        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }
}
