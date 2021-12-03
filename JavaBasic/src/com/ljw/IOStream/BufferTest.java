package com.ljw.IOStream;

import org.junit.Test;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

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

    @Test
<<<<<<< Updated upstream
    public void bufferReaderAndWriter() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("")));
            bw = new BufferedWriter(new FileWriter(new File("")));

            char[] buffer = new char[1024];
            int len;
//            while ((len = br.read(buffer)) != -1) {
//                bw.write(buffer, 0, len);
//            }
            String str;
            while ((str = br.readLine()) != null) {
                bw.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
=======
    public void test() {
//        int[] arr = new int[]{0, 6, -10, 2, 99, -99};
//        Arrays.sort(arr, ( Integer a, Integer b) -> { return b-a;});

        // 方式一
//        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>(){
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//
//        q.offer(1);
//        q.offer(2);
//        System.out.println(q.peek());
//
//        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2)-> o2 - o1);
//        queue.offer(123);
//        queue.offer(0);
//        queue.offer(12);
//
//        while (!queue.isEmpty()) {
//            System.out.println(queue.poll());
//        }


        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(deque);

>>>>>>> Stashed changes
    }
}
