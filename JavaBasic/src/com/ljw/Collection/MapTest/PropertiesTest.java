package com.ljw.Collection.MapTest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author lanjuwen
 * @create 2021-11-22  0:43
 */
public class PropertiesTest {
    @Test
    public void test() {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();
            fis = new FileInputStream("F:\\project\\Java\\Yupi\\JavaBasic\\src\\jdbc.properties");
            pros.load(fis);

            String name = pros.getProperty("name");
            String password = pros.getProperty("password");

            System.out.println("name = " + name + ", password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
