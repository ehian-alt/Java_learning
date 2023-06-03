package reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class reflection2 {
    @SuppressWarnings("all")
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        // Class对象
        Class C1 = Class.forName("reflection.User2");
        // 获得注解
        Annotation[] annotations = C1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        // 获得注解值
        typeAnno typeAnno = (typeAnno)C1.getAnnotation(typeAnno.class);
        String value = typeAnno.value();
        System.out.println(value);

        // 获得属性的注解
        Field name = C1.getDeclaredField("name");
        fieldAnno fName = name.getAnnotation(fieldAnno.class);
        System.out.println(fName.columName());
        System.out.println(fName.type());
        System.out.println(fName.length());

    }
}

@typeAnno("user")
class User2{
    @fieldAnno(type = "int", length = 5, columName = "id")
    private int id;
    @fieldAnno(type = "int", length = 5, columName = "age")
    private int age;
    @fieldAnno(type = "String", length = 10, columName = "name")
    private String name;

    private void Test(){}

    public User2() {
    }

    public User2(int id, int age, String name) {
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

// 类的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface typeAnno{
    String value();
}

// 属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface fieldAnno{
    String type();
    int length();

    String columName();
}
