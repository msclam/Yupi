package com.ljw.IOStream;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderWriter {
    public static void main(String[] args) {
        File file = new File("test.txt");
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void test() throws IOException {
        FileReader fr = null;
        try {
            // 实例化file对象
            File file = new File("D:\\code\\Java\\IntellJ-workspace\\Yupi\\JavaBasic\\src\\com\\ljw\\IOStream\\test.txt");
            // 提供具体的流
            fr = new FileReader(file);
            // 返回读出字符，到文件末尾返回-1

            // 方式一
//        int data = fr.read();
//        while (data != -1) {
//            System.out.println((char) data);
//            data = fr.read();
//        }

            // 方式二
            int data;
            while ((data = fr.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() throws IOException {
        // 1 File实例化
        FileReader fr = null;
        try {
            File file = new File("D:\\code\\Java\\IntellJ-workspace\\Yupi\\JavaBasic\\src\\com\\ljw\\IOStream\\test.txt");

            // 2 FileReader流的实例化
            fr = new FileReader(file);

            // 3 读入的操作
            char[] chars = new char[100];
            int len;
            while ((len = fr.read(chars)) != -1) {
//                for (int i = 0; i < len; i++) {
//                    System.out.println((char) chars[i]);
//                }
                String str = new String(chars, 0, len);
                System.out.println(chars);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4 资源的关闭
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3() {
        FileWriter fw = null;
        try {
            File file = new File("D:\\code\\Java\\IntellJ-workspace\\Yupi\\JavaBasic\\src\\com\\ljw\\IOStream\\test.txt");

            fw = new FileWriter(file, true);

            fw.write("private string");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test4() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcFile = new File("test.txt");
            File destFile = new File("test_write.txt");

            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            char[] cbuf = new char[100];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fr != null)
                        fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test5() {
        String s = "abcdefg";
        System.out.println(s.substring(2, 4));

        List<List<Integer>> list = new ArrayList<>();

    }


}
