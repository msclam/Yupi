package com.ljw.IOStream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class FileInputStreamOutputStream {
    @Test
    public void test6() {
        FileInputStream fis = null;
        try {
            String filePath = "D:\\code\\Java\\IntellJ-workspace\\Yupi\\JavaBasic\\src\\com\\ljw\\IOStream\\test.txt";
            // 1 造文件
            File file = new File(filePath);
            // 2 造流
            fis = new FileInputStream(file);

            byte[] buffer = new byte[10];
            int len;
            // 3 读流
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    // 4 关闭资源
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void copyFile(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] buffer = new byte[10];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                // String str = new String(buffer, 0, len);
                // System.out.println(str);
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        new HashMap<>();
    }
}
