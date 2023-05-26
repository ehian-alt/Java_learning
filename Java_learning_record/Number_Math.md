# Number and Math

一般情况下我们会使用数据的基本数据类型: byte、int、short、long、double、float、boolean、char;  

对应的包装类型也有八种:Byte、Integer、Short、Long、Double、Float、Boolean、Character;

Number类是java.lang包下的一个抽象类，提供了将包装类型拆箱成基本类型的方法，所有基本类型(数据类型)的包装类型都继承了该抽象类，并且是final声明不可继承改变;

也就是说只有对应的包装类才能够调用方法`int.compareTo(i)`是不合法的

### *常用的Number类和Math类方法:*

>1: compareTo()
* 如果对象比参数大返回1，相等返回0，否则返回-1
```java
public class Number_and_Math {
    public static void main(String[] args){
        Integer x = 6;
        System.out.println(x.compareTo(1));
        System.out.println(x.compareTo(6));
        System.out.println(x.compareTo(9));
    }
}
```
输出结果如下：

    1
    0
    -1

> 2: equals()
* 判断对象是否与参数相等
* 如果参数不为Null，并且参数的类型和值都相等返回true, 否则返回false
```java
public class Number_and_Math {
    public static void main(String[] args){
        Integer x = 5;
        Integer a = 6;
        Integer b = 5;
        Short y = 5;
        int z = 5;
        System.out.println(x.equals(y));
        System.out.println(x.equals(z));
        System.out.println(x.equals(5));
        System.out.println(x.equals(a));
        System.out.println(x.equals(b));
    }
}
```

输出结果如下:

    false
    true
    true
    false
    true

> 3: valueOf 
* 静态方法，有三种语法格式，对应三种参数形式

      static (object) valueOf(int i)
      static (object) valueOf(String s)
      static (object) valueOf(String s, int radix)
* 返回Integer实例或对象
```java
public class Number_and_Math {
    public static void main(String[] args){
      String s = "520";
      System.out.println(Integer.valueOf(s));
      System.out.println(Double.valueOf(s));
      System.out.println(Float.valueOf(7));
      System.out.println(Integer.valueOf(s, 16)); // 16进制
    }
}
```

输出结果如下:

    520
    520.0
    7.0
    1312

> 4: toString()
* 以字符串形式返回值
```java
public class Number_and_Math {
    public static void main(String[] args) {
        Integer x = 10;
        System.out.println(x.toString());
        System.out.println(Integer.toString(6));
    }
}
```
输出结果如下:

    10
    6

> 5: abs() 
* 返回参数的绝对值
```java
public class Number_and_Math {
    public static void main(String[] args) {
      System.out.println(Math.abs(8.8));
      System.out.println(Math.abs(-9.9));
    }
}
```
输出结果如下:

    8.8
    9.9

> 6: ceil()  floor()
* ceil():返回大于等于参数的最小整数
* floor():返回小于等于参数的最大整数
* 返回值类型都是双精度型浮点数
```java
public class Number_and_Math {
    public static void main(String[] args) {
      System.out.println(Math.ceil(-8.3));
      System.out.println(Math.ceil(8.3));

      System.out.println(Math.floor(-1.6));
      System.out.println(Math.floor(1.6));
    }
}
```

输出结果如下:

    -8.0
    9.0
    -2.0
    1.0

> 7: min() max()
* 返回 ***两个参数*** 的最小值或最大值
```java
public class Number_and_Math{
    public static void main(String[] args){
      System.out.println(Math.max(5, 10));
      System.out.println(Math.min(5, 10.0));
    }
}
```

输出结果如下:

    10
    5.0

> 8: pow()  sqrt()
* pow(x, y): 返回x的y次方
* sqrt(x): 返回x的平方根
```java
public class Number_and_Math{
    public static void main(String[] args){
        int x = 2, y = 4;
        System.out.printf("%d的%d次方的结果为: %.1f\n",x, y, Math.pow(x,y));
        System.out.printf("%d的平方根为: %.1f", y, Math.sqrt(y));
    }
}
```

运行结果如下:

    2的4次方结果为: 16.0
    4的平方根为: 2.0

> 9: random()
* 返回一个在0.0到1`(0.0<=Math.random()<1)`之间的随机实数
```java
public class Number_and_Math{
    public static void main(String[] args){
      System.out.println(Math.random());
      System.out.println(Math.random());
    }
}
```

运行结果如下:

    0.2550419464155895
    0.9798459692336131
