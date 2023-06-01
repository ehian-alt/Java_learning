 # HashMap

HashMap 是一个散列表，它存储的内容是键值对(key-value)映射。

HashMap 实现了 Map 接口，根据键的 HashCode 值存储数据，具有很快的访问速度，最多允许一条记录的键为 null，不支持线程同步。

HashMap 是无序的，即不会记录插入的顺序.

HashMap 的 key 与 value 类型可以相同也可以不同，可以是字符串（String）类型的 key 和 value，也可以是整型（Integer）的 key 和字符串（String）类型的 value。

引入HashMap  
`import java.util.HashMap;`  

创建一个对象  
`HashMap<Integer, String> Sites = new HashMap<Integer, String>();`

## HashMap方法

1. clear() 删除hashMap中所有键值对
2. clone() 复制一份hashMap
3. isEmpty() 判断hashMap
4. size() 计算hashMap
5. put() 将键值对添加到hashMap中
6. putAll() 将所有键值对添加到hashMap中
7. putIfAbsent() 如果hashMap中不存在指定的键，则将指定的键值对hashMap中 
8. remove()	删除 hashMap 中指定键 key 的映射关系
9. containsKey()	检查 hashMap 中是否存在指定的 key 对应的映射关系。
10. containsValue()	检查 hashMap 中是否存在指定的 value 对应的映射关系。
11. replace()	替换 hashMap 中是指定的 key 对应的 value。
12. replaceAll()	将 hashMap 中的所有映射关系替换成给定的函数所执行的结果。
13. get()	获取指定 key 对应对 value
14. getOrDefault()	获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值 
15. forEach()	对 hashMap 中的每个映射执行指定的操作。
16. entrySet()	返回 hashMap 中所有映射项的集合集合视图。
17. keySet()	返回 hashMap 中所有 key 组成的集合视图。
18. values()	返回 hashMap 中存在的所有 value 值。
19. merge()	添加键值对到 hashMap 中
20. compute()	对 hashMap 中指定 key 的值进行重新计算
21. computeIfAbsent()	对 hashMap 中指定 key 的值进行重新计算，如果不存在这个 key，则添加到 hasMap 中
22. computeIfPresent()	对 hashMap 中指定 key 的值进行重新计算，前提是该 key 存在于 hashMap 中。


```java
public class HashMap_ {
    public static void main(String[] args) {
        HashMap<String, Integer> dic = new HashMap<>();
        dic.put("Hello", 1);
        dic.put("World", 2);
        dic.put("Java", 0);
        dic.put("learning", 4);
        System.out.println(dic.size());
        dic.clear();
        System.out.println(dic.isEmpty());
        dic.putIfAbsent("Hello", 5);
        System.out.println(dic.containsKey("Hello"));
        System.out.println(dic.containsValue(5));
        dic.replace("Hello", 8);
        System.out.println(dic.get("Hello"));
        dic.forEach((key, value) -> {
            value = value * 2;
            System.out.println(key + ":" + value);
        });
    }
}
```

运行结果如下:

    4
    true
    true
    true
    8
    Hello:16

```java
public class HashMap_ {
    public static void main(String[] args){
        HashMap<String, Integer> dic = new HashMap<>();
        dic.merge("Hello", 0, (oldValue, newValue) -> oldValue+1);
        System.out.println(dic.keySet());
        System.out.println(dic.values());        
        System.out.println(dic.entrySet());
        dic.compute("Hello", (key, value) -> value + 2);
        System.out.println(dic.entrySet());
        dic.computeIfAbsent("Hello", value -> 88);
        System.out.println(dic.entrySet());
        dic.computeIfPresent("Hello", (key, value) -> value*2);
        System.out.println(dic.entrySet());

    }
}
```

运行结果如下:

    [Hello]
    [1]
    [Hello=1]
    [Hello=3]
    [Hello=3]
    [Hello=6]
