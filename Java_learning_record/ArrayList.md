# ArrayList
`import java.util.ArrayList; // 引入 ArrayList 类`

`ArrayList<E> objectName =new ArrayList<>();　 // 初始化`

## ArrayList 方法

### add()
* 将元素插入到指定位置的 arraylist 中

### addAll()
* 添加集合中的所有元素到 arraylist 中

### clear()
* 删除 arraylist 中的所有元素

### clone()
* 复制一份 arraylist

### contains()
* 判断元素是否在 arraylist
* 返回值是Boolean类型

### get()
* 通过索引值获取 arraylist 中的元素

### indexOf()
* 返回 arraylist 中元素的索引值

```java
import java.util.ArrayList;

public class ArrayList_ {
    public static void main(String[] args){
        ArrayList<String> sList = new ArrayList<String>();
        sList.add("Hello");
        sList.add("World");
        ArrayList<String> nList = (ArrayList<String>) sList.clone();
        sList.addAll(nList);
        for (String s : sList){
            System.out.println("sList中的元素:" + s);
        }
        nList.clear();
        System.out.println("nList.clear()后的字符串形式" + nList.toString());
        System.out.println(sList.contains("World"));
        System.out.println(sList.indexOf("World"));
        System.out.println(sList.get(0));
    }
}
```

运行结果如下:

    sList中的元素:Hello
    sList中的元素:World
    sList中的元素:Hello
    sList中的元素:World
    nList.clear()后的字符串形式[]
    true
    1
    Hello

### removeAll()
* 删除存在于指定集合中的 arraylist 里的所有元素

### remove()
* 删除 arraylist 里的单个元素
* 返回值是被删除的对象

### size()
* 返回 arraylist 里元素数量

### isEmpty()
* 判断 arraylist 是否为空

### subList()
* 截取部分 arraylist 的元素

### set()
* 替换 arraylist 中指定索引的元素

### sort()
* 对 arraylist 元素进行排序

### toArray()
* 将 arraylist 转换为数组

### toString()
* 将 arraylist 转换为字符串

```java
public class ArrayList_ {
    public static void main(String[] args){
        ArrayList<String> sList = new ArrayList<String>();
        sList.add("Hello");
        sList.add("World");
        sList.add("Java");
        sList.add("learning");
        System.out.println(sList.remove(0));
        System.out.println(sList.size());
        System.out.println(sList.isEmpty());
        System.out.println(sList.subList(1, 2));
        sList.set(1, "github");
        System.out.println("替换之后:" + sList.toString());
        sList.sort(Comparator.reverseOrder());
        System.out.println("倒序排序之后:" + sList);
        String[] sArr = new String[sList.size()];
        sList.toArray(sArr);
        System.out.println("sArr:" +Arrays.toString(sArr));

    }
}
```

运行结果如下:

    Hello
    3
    false
    [Java]
    替换之后:[World, github, learning]
    倒序排序之后:[learning, github, World]
    sArr:[learning, github, World]

### ensureCapacity()
* 设置指定容量大小的 arraylist
* 这是个动态的容量

### lastIndexOf()
* 返回指定元素在 arraylist 中最后一次出现的位置

### retainAll()
* 保留 arraylist 中在指定集合中也存在的那些元素

### containAll()
* 查看 arraylist 是否包含指定集合中的所有元素

### trimToSize()
* 将 arraylist 中的容量调整为数组中的元素个数

### removeRange()
* 删除 arraylist 中指定索引之间存在的元素

### replaceAll()
* 将给定的操作内容替换掉数组中每一个元素

### removeIf()
* 删除所有满足特定条件的 arraylist 元素

### forEach()
* 遍历 arraylist 中每一个元素并执行特定操作

```java
import java.util.ArrayList;

public class ArrayList_ {
    public static void main(String[] args){
        ArrayList<String> sList = new ArrayList<String>();
        sList.ensureCapacity(4);
        sList.add("Hello");
        sList.add("World");
        sList.add("Hello");
        sList.add("World");
        sList.add("Hello");
        sList.add("World");
        System.out.println(sList.lastIndexOf("Hello"));
        sList.replaceAll(String::toUpperCase);
        System.out.println("replaceAll:" + sList.toString());
        sList.removeIf(e -> e.contains("ld"));
        System.out.println("removeIf" + sList.toString());
        sList.forEach((e) -> {
            e += "Each";
            System.out.println("forEach:" + e);
        });
        System.out.println(sList);
    }
}
```

运行结果如下:

    4
    replaceAll:[HELLO, WORLD, HELLO, WORLD, HELLO, WORLD]
    removeIf[HELLO, WORLD, HELLO, WORLD, HELLO, WORLD]
    forEach:HELLOEach
    forEach:WORLDEach
    forEach:HELLOEach
    forEach:WORLDEach
    forEach:HELLOEach
    forEach:WORLDEach
    [HELLO, WORLD, HELLO, WORLD, HELLO, WORLD]