package reflection;

public class Test02 {
    // 什么是反射
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("reflection.User");
        System.out.println(c1); // 一个类在内存中只有一个class对象

        // 一个类加载在内存中，类的结构被封装在Class对象中
        System.out.println(c1.hashCode());
    }
}

class User {
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}