package reflection;

public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取系统类的加载器
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);

        // 获取系统类加载器的父类->扩展类加载器
        ClassLoader parent = loader.getParent();
        System.out.println(parent);

        // 获取扩展类加载器的父类->根加载器
        ClassLoader root = parent.getParent();
        System.out.println(root); // null

        // 测试当前类是由哪个加载器加载的
        ClassLoader classLoader = Class.forName("reflection.Test07").getClassLoader();
        System.out.println(classLoader);

        // 测试jdk中内置的类谁加载的
        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);

        // 如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

        //F:\Java\jdk1.8.0_162\jre\lib\charsets.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\deploy.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\ext\access-bridge-64.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\ext\cldrdata.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\ext\dnsns.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\ext\jaccess.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\ext\jfxrt.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\ext\localedata.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\ext\nashorn.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\ext\sunec.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\ext\sunjce_provider.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\ext\sunmscapi.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\ext\sunpkcs11.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\ext\zipfs.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\javaws.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\jce.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\jfr.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\jfxswt.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\jsse.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\management- agent.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\plugin.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\resources.jar;
        // F:\Java\jdk1.8.0_162\jre\lib\rt.jar;
        // D:\code\Java\IntellJ-workspace\Yupi\out\production\ReflectionAndAnnotation;
        // F:\software\JetBrains\IntelliJ IDEA 2020.2.3\lib\idea_rt.jar

        // 双亲委派机制
            // java.lang.String ->
    }
}
