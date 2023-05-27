# Character
#### java为内置数据类型char类型提供了包装类Character类, 通常单引号 （''） 内表示字符型；
#### 将一个char类型的参数传递给需要一个Character类型参数时，那么编译器会自动地将char类型参数转换为Character对象。这种特征成为装箱,反之称为拆箱

### 转义字符( '\\' )
反斜杠(\)对编译器来说有特殊含义

以下是常见的Java 的转义序列

| 转义序列 | 描述  |
|:----:|:---:|
|  \t  | 制表符 |
|  \n  | 换行  |
|  \r  | 回车  |
|  \b  | 后退符 |
|  \f  | 换页符 |

### Character 方法

1. isLetter() 判断是否为一个字母
2. isDigit()  判断是否为一个数字字符
3. isWhitespace() 判断是否为一个空格
4. isUpperCase()  判断是否为大写字母
5. isLowerCase()  判断是否为小写字母
6. toUpperCase()  返回指定字母的大写形式
7. toLowerCase()  返回指定字母的小写形式
8. toString()  返回字符的字符串形式，长度为1

```java
public class Character_ {
    public static void main(String[] args){
        Character ch = '\"';
        System.out.println(ch);
        System.out.println(Character.isLetter('a'));
        System.out.println(Character.isDigit('a'));
        System.out.println(Character.isWhitespace(' '));
        System.out.println(Character.isUpperCase('a'));
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.toUpperCase('a'));
        System.out.println(Character.toLowerCase('a'));
        System.out.println(Character.toString('a'));
    }
}
```

运行结果如下:

    "
    true
    false
    true
    false
    true
    A
    a
    a

