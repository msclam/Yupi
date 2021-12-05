package com.ljw.ObjectInputOutputStream;




import org.junit.Test;

import java.io.*;

public class ObjectInputOutputStreamTest {
    // 序列化： 将内存中的java对象存到磁盘中
    @Test
    public void test1() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));

            oos.writeObject(new String("我爱你"));
            oos.flush();

            oos.writeObject(new People("abc", 123));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // 反序列化
    @Test
    public void test2() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);

            People p = (People) ois.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test3() {
        StringBuffer strb = new StringBuffer("abcd");
        strb.deleteCharAt(1);
        System.out.println(strb.toString());
    }
}
