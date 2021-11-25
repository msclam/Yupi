package com.ljw.generic.exer;

import org.junit.Test;

import java.util.List;

public class DAOTest {
    @Test
    public void test() {
        CustomerDAO dao1 = new CustomerDAO();

        dao1.add(new Customer());
        List<Customer> forList = dao1.getForList(10);
    }
}
