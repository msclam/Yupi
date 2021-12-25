package com.atguigu3.bean;

import java.sql.Date;

/**
 * @author lanjuwen
 * @create 2021-12-25  17:49
 */
public class Customer {
    //ORM 对象关系映射
    /*
    * 一个表等于一个类，一条记录等于一个对象 一个字段等于一个属性
    * */
    private int id;
    private String name;
    private String email;
    private Date birth;

    public Customer() {
    }
    public Customer(int id, String name, String email, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
    }
}
