package com.ljw.oop;

public class PersonTest {
    public static void main(String[] args) {
        Person[] pers = new Person[20];
        for (int i = 0; i < pers.length; i ++ ) {
            pers[i] = new Person();
//            System.out.println(pers[i]);
            pers[i].number = i + 1; // 学号
            pers[i].state = (int)(Math.random() * (6 - 1 + 1) + 1); // [1, 6]年级
            pers[i].score = (int)(Math.random() * (100 - 0 + 0) + 1); // [0, 100]分数
        }

        for (int i = 0; i < pers.length; i ++ ) {
            pers[i].info();
        }
        System.out.println("================================");
        int n = pers.length;
        for (int i = 0; i < n - 1; i ++ ) {
            for (int j = 0; j < n - i - 1; j ++ ) {
                if (pers[j + 1].score < pers[j].score) {
                    swap(pers, j, j + 1);
                }
            }
        }
        System.out.println("================================");
        for (int i = 0; i < pers.length; i ++ ) {
            pers[i].info();
        }
    }
    public static void swap(Person[] p, int i, int j) {
        Person tmp = p[i];
        p[i] = p[j];
        p[j] = tmp;
    }
}
