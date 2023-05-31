# HashSet

HashSet 基于 HashMap 来实现的，是一个***不允许有重复元素***的集合。

HashSet 允许有 null 值。

HashSet 是***无序的***，即不会记录插入的顺序。

HashSet 不是线程安全的， 如果多个线程尝试同时修改 HashSet，则最终结果是不确定的。 您必须在多线程访问时显式同步对 HashSet 的并发访问。

HashSet类位于java.util包中  
`import java.util.HashSet;` // 引入 HashSet 类

创建HashSet对象:  
`HashSet<String> sites = new HashSet<String>();`

### HashSet方法

1. add() 添加元素
2. contains() 判断元素是否存在于集合当中
3. remove() 删除元素
4. clear() 删除集合中所有元素
5. size() 返回集合大小

```java
import java.util.HashSet;

public class HashSet_ {
    public static void main(String[] args){
        HashSet<String> hs = new HashSet<String>();
        hs.add("Hello");
        hs.add("World");
        hs.add("Java");
        hs.add("learning");
        hs.add("Hello"); // 重复元素不会添加到HashSet中
        System.out.println(hs.toString());
        System.out.println(hs.contains("Hello"));
        System.out.println(hs.size());
        hs.remove("Java");
        for (String s : hs){
            System.out.print(s + " ");
        }
        hs.clear();
        System.out.println("\n" + hs.size());
    }
}
```

运行结果如下:

    [Java, Hello, learning, World]
    true
    4
    Hello learning World
    0
