package com.ljw.AnnotationTest;

import org.junit.Test;

import java.lang.annotation.Annotation;

/**
 * @author lanjuwen
 * @create 2021-11-19  16:53
 */
@MyAnnotation(value = "hello")
public class Person {

    @Test
    public void test() {
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i ++ ) {
            System.out.println(annotations[i]);
        }
    }

}
class Student extends Person {

}
