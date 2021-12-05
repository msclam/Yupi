package com.ljw.ObjectInputOutputStream;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("hi.txt"), "r");
            raf2 = new RandomAccessFile(new File("hi_1.txt"), "rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf1 != null)
                raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (raf2 != null)
                raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() throws IOException {
        // 实现插入的效果
        RandomAccessFile raf = new RandomAccessFile("hi.txt", "r");
        raf.seek(3);
        byte[] buffer = new byte[20];
        int len;
        StringBuilder strb = new StringBuilder();
        while ((len = raf.read(buffer)) != -1) {
            strb.append(new String(buffer, 0, len));
        }

        raf.seek(3);
        raf.write("xyz".getBytes());
        raf.write(strb.toString().getBytes());
    }
}
