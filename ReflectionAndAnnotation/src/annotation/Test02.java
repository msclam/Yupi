package annotation;

import java.lang.annotation.*;

// 测试元注解
public class Test02 {
    @MyAnnotation
    public void test() {

    }
}

// 定义一个注解
@Target(value = {ElementType.METHOD, ElementType.TYPE}) // 表示注解用于什么地方
@Retention(value = RetentionPolicy.RUNTIME)  // 表示注解在什么地方还有效 runtime > class > sources
@Documented /* 表示是否将我们的注解生成在java doc中*/
@Inherited // 子类可以继承父类的注解
@interface MyAnnotation {

}
