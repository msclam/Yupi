package com.ljw.File;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author lanjuwen
 * @create 2021-11-28  19:10
 */
public class FileTest {
    @Test
    public void test() {
        File file = new File("hello.txt");
        System.out.println(file);
        System.out.println(file.isFile());

        File file1 = new File("d:\\abc", "child");
        System.out.println(file1);

        File file2 = new File(file1, "test.txt");
        System.out.println(file2);
    }

    @Test
    public void test1() {
        File file = new File("F:\\project\\Java\\Yupi");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    @Test
    public void test2() throws IOException {
        File file = new File("hi.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("创建成功");
        } else {
            file.delete();
            System.out.println("删除成功");
        }
    }
    @Test
    public void test3() {
        File file = new File("F:\\project\\Java\\Yupi\\666");
        file.mkdir();
    }
}
