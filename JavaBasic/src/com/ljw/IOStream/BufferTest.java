package com.ljw.IOStream;

import org.junit.Test;

import java.io.*;

public class BufferTest {
    @Test
    public void bufferStream() {
        // 1 文件
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            String filePath = "D:\\code\\Java\\IntellJ-workspace\\Yupi\\JavaBasic\\src\\com\\ljw\\IOStream\\msclam.jpg";
            String filePath2 = "D:\\code\\Java\\IntellJ-workspace\\Yupi\\JavaBasic\\src\\com\\ljw\\IOStream\\msclam_cpy.jpg";
            File srcFile = new File(filePath);
            File destFile = new File(filePath2);

            // 2 造流
            // 2.1 造文件流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // 2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 3 复制的读入、写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4 资源的关闭(先外再内)
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 关闭外层流，内层流也会关闭
//        fos.close();
//        fis.close();
        }
    }
}
