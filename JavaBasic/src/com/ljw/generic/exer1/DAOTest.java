package com.ljw.generic.exer1;

import java.util.List;

/**
 * @author lanjuwen
 * @create 2021-11-26  1:16
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();

        dao.save("1001", new User(1001, 34, "abc"));
        dao.save("1002", new User(1002, 54, "def"));
        dao.save("1003", new User(1003, 76, "gcj"));

        List<User> list = dao.list();
        list.forEach(System.out::println);
    }
}
