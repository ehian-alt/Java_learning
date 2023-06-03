package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test01 {
    // 通过反射获取类的class对象
    @SuppressWarnings("all")
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 使用静态方法 forName 获取 Class 实例
        Class C1 = Class.forName("reflection.User");
        // getClass() 获取Class实例
        User u = new User();
        Class C2 = u.getClass();
        // 通过一个 class 的静态变量class获取
        Class C3 = User.class;

        // 通过反射创建一个对象   本质是调用无参构造方法，创建对象
        User u1 = (User)C1.newInstance();

        // 通过有参构造器创建对象  （类加载器）
        Constructor constructor = C1.getDeclaredConstructor(int.class, int.class, String.class);
        User u2 = (User) constructor.newInstance(1, 18, "Hello");

        // 通过反射获取，调用普通方法
        Method m1 = C1.getDeclaredMethod("setName", String.class);
//        Method[] methods = C1.getMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }
        // invoke : 激活, 调用方法 (对象, 方法的参数值)
        m1.invoke(u1, "Hello");
        System.out.println("name:"+u2.getName());

        // 通过反射获得成员变量
        Field id = C1.getDeclaredField("id");

        // 不能直接操作私有属性，要先关闭安全检测: setAccessible(true)
        id.setAccessible(true);
        id.set(u2, 3);
        System.out.println("id:"+u2.getId());


    }
}


class User{
    private int id;
    private int age;
    private String name;

    private void Test(){}

    public User() {
    }

    public User(int id, int age, String name) {
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
}