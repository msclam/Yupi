package reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// 练习反射操作注解
public class Test12 {
}

class Student2 {
    private int id;
    private int age;
    private String name;

    public Student2() {}

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

@Target(ElementType.TYPE)
@interface Tablek {
    String value();

}
