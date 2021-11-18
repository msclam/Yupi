package com.ljw.compareTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lanjuwen
 * @create 2021-11-18  10:43
 */
public class CompareTest {
    @Test
    public void test() {
        // Comparable接口的使用
        String[] arr = new String[] {"aa", "gg", "jj", "dd", "mm", "cc", "kk"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        Goods[] arr = new Goods[4];
//        System.out.println(arr[0]);
        arr[0] = new Goods("a", 12);
        arr[1] = new Goods("c", 2);
        arr[2] = new Goods("b", 32);
        arr[3] = new Goods("d", 22);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test3() {
        String[] arr = new String[] {"aa", "gg", "jj", "dd", "mm", "cc", "kk"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入的类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4() {
        Goods[] arr = new Goods[4];
//        System.out.println(arr[0]);
        arr[0] = new Goods("a", 12);
        arr[1] = new Goods("c", 2);
        arr[2] = new Goods("b", 32);
        arr[3] = new Goods("d", 22);

        Arrays.sort(arr, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if (o1.getName().equals(o2.getName())) {
                    return Double.compare(o1.getPrice(), o2.getPrice());
                } else {
                    return -o1.getName().compareTo(o2.getName());
                }
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
