package annotation;

import java.util.ArrayList;
import java.util.List;

public class Test01 extends Object {
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public static void test() {
        System.out.println("deprecated");
    }

    @SuppressWarnings("all")
    public void test02() {
        List list = new ArrayList();
    }

    public static void main(String[] args) {
        test();
    }
}
