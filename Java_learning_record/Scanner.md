# Scanner

java.util.Scanner 是 Java5 的新特征，我们可以通过 Scanner 类来获取用户的输入。

下面是创建 Scanner 对象的基本语法：

Scanner s = new Scanner(System.in);
接下来我们演示一个最简单的数据输入，并通过 Scanner 类的 next() 与 nextLine() 方法获取输入的字符串，在读取前我们一般需要 使用 hasNext 与 hasNextLine 判断是否还有输入的数据：

使用 next 方法：  
ScannerDemo.java 文件代码：
```java
import java.util.Scanner;

public class Scanner_ {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
    
        // next方式接收字符串
        System.out.println("next方式接收：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
        }
        scan.close();
    }
}
```
执行以上程序输出结果为：

    next方式接收：
    hello world
    输入的数据为：hello
可以看到 world 字符串并未输出，接下来我们看 nextLine。

使用 nextLine 方法：  
ScannerDemo.java 文件代码：
```java
import java.util.Scanner;

public class Scanner_ {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
    
        // nextLine方式接收字符串
        System.out.println("nextLine方式接收：");
        // 判断是否还有输入
        if (scan.hasNextLine()) {
            String str2 = scan.nextLine();
            System.out.println("输入的数据为：" + str2);
        }
        scan.close();
    }
}
```
执行以上程序输出结果为：

    nextLine方式接收：
    hello world
    输入的数据为：hello world
可以看到 world 字符串输出。

* 以下实例我们可以输入多个数字，并求其总和与平均数，每输入一个数字用回车确认，通过输入非数字来结束输入并输出执行结果：

ScannerDemo.java 文件代码：
```java
import java.util.Scanner;

class Scanner_ {
    public static void main(String[] args) {
        System.out.println("请输入数字：");
        Scanner scan = new Scanner(System.in);

        double sum = 0;
        int m = 0;
 
        while (scan.hasNextDouble()) {
            double x = scan.nextDouble();
            m = m + 1;
            sum = sum + x;
        }
 
        System.out.println(m + "个数的和为" + sum);
        System.out.println(m + "个数的平均值是" + (sum / m));
        scan.close();
    }
}
```
执行以上程序输出结果为（输入非数字来结束输入）：

    请输入数字：
    12
    23
    15
    21.4
    end
    4个数的和为71.4
    4个数的平均值是17.85

