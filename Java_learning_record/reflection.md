# 反射

反射是为了解决在运行期，对某个实例一无所知的情况下，如何调用其方法。

`class`是由JVM在执行过程中动态加载的。JVM在第一次读取到一种`class`类型时，将其加载进内存。

每加载一种`class`，JVM就为其创建一个`Class`类型的实例，并关联起来。注意：这里的Class类型是一个名叫 `Class` 的 `class`。它长这样：

    public final class Class {
        private Class() {}
    }
以 `String` 类为例，当JVM加载 `String` 类时，它首先读取 `String.class` 文件到内存，然后，为 `String` 类创建一个 `Class` 实例并关联起来：

`Class cls = new Class(String);`  
这个 `Class` 实例是JVM内部创建的，如果我们查看JDK源码，可以发现 `Class` 类的构造方法是 `private`，只有JVM能创建 `Class` 实例，我们自己的Java程序是无法创建 `Class` 实例的。

所以，JVM持有的每个 `Class` 实例都指向一个数据类型( `class` 或 `interface` )：

一个 `Class` 实例包含了该 `Class` 的所有完整信息:

| Class Instance              |
|-----------------------------|
| name = "java.lang.String"   |
| package = "java.lang"       |
| super = "java.lang.Object"  |
| interface = CharSequence... |
| field = value[],hash,...    |
| method = indexOf()...       |

**由于JVM为每个加载的 `class` 创建了对应的 `Class` 实例，并在实例中保存了该 `class` 的所有信息，包括类名、包名、父类、实现的接口、所有方法、字段等，因此，如果获取了某个 `Class` 实例，我们就可以通过这个 `Class` 实例获取到该实例对应的 `class` 的所有信息。**

**这种通过 `Class` 实例获取 `class` 信息的方法称为反射（ `Reflection` ）。**

反射相关主要的API
* `java.lang.Class` 代表一个类
* `java.lang.reflect.Method` 代表一个类的方法
* `java.lang.reflect.Filed` 代表类的成员变量
* `java.lang.reflect.Constructor` 代表类的构造器

如何获取一个`class`的`Class`实例？有三个方法：

方法一：直接通过一个`class`的静态变量`class`获取：

`Class cls = String.class;`

方法二：如果我们有一个实例变量，可以通过该实例变量提供的`getClass()`方法获取：

    String s = "Hello";
    Class cls = s.getClass();

方法三：如果知道一个`class`的完整类名，可以通过静态方法`Class.forName()`获取：

`Class cls = Class.forName("java.lang.String");`

## 示例

### 首先我们定义了一个User类

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

### 获取Class实例

    // 方法三: 使用静态方法 forName 获取 Class 实例
    Class C1 = Class.forName("reflection.User");
    // 方法二: getClass() 获取Class实例
    User u = new User();
    Class C2 = u.getClass();
    // 方法一: 通过一个 class 的静态变量class获取
    Class C3 = User.class;

### 创建对象:

    // 通过反射创建一个对象   本质是调用无参构造方法，创建对象
    User u1 = (User)C1.newInstance();

    // 通过有参构造器创建对象  （类加载器）
    Constructor constructor = C1.getDeclaredConstructor(int.class, int.class, String.class);
    User u2 = (User) constructor.newInstance(1, 18, "Hello");

### 访问字段
get可以获取到该类以及集成到的方法以及字段  
getDeclared可以获取本类包括private权限的所有方法和变量

    // 通过反射获得成员变量
    Field id = C1.getDeclaredField("id");

    // 不能直接操作私有属性，要先关闭安全检测: setAccessible(true)
    id.setAccessible(true);
    id.set(u2, 3);
    System.out.println(u2.getId());

### 调用方法

    // 通过反射获取，调用普通方法
    Method m1 = C1.getDeclaredMethod("setName", String.class);
    //    Method[] methods = C1.getMethods();
    //    for (Method method : methods) {
    //        System.out.println(method);
    //    }
    // invoke : 激活, 调用方法 (对象, 方法的参数值)
    m1.invoke(u1, "Hello");
    System.out.println(u2.getName());

完整代码:
```java
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
```
运行如下:

    Hello
    3

## 反射操作注解

```java
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
```

运行结果如下:

    user
    name
    String
    10

