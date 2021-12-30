package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Test11 {
    public void test01(Map<String, User> map, List<User> list) {
        System.out.println("test01");
    }

    public Map<String, User> test02() {
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test11.class.getMethod("test01", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("#" + genericParameterType);
            if (genericParameterType instanceof ParameterizedType) {
                Type[] types = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type type : types) {
                    System.out.println(type);
                }
            }
        }

        method = Test11.class.getMethod("test02", null);
        Type getGenericReturnType = method.getGenericReturnType();
        if (getGenericReturnType instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType) getGenericReturnType).getActualTypeArguments();
            for (Type type : types) {
                System.out.println(type);
            }
        }
    }
}
