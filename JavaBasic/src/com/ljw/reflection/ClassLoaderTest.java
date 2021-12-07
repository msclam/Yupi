package com.ljw.reflection;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class ClassLoaderTest {
    @Test
    public void test() throws Exception {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        properties.load(fis);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println(user + ":" + password);
    }
}
