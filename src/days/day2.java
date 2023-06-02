package days;

import java.awt.*;
import java.io.PrintStream;
import java.util.Arrays;

public class day2 {
    public static void main(String[] args){
        String s = "1112223";
        char[] charr = {'H', 'e', 'l', 'l', '0', 'W', 'o', 'r', 'l', 'd'};
        String newstr = new String(charr);
        System.out.println(s);
        // 定位
        // indexOf 返回目标字符/字符串在原字符串中的索引位置int
        System.out.println(s.indexOf('2'));
        System.out.println(s.indexOf('2', 4));     // 从索引为4开始找‘2’;
        System.out.println(s.indexOf("223"));
        System.out.println(newstr.lastIndexOf('l'));        // 最后出现的位置
        // 获取子串
        System.out.println(newstr.substring(5));    // [5:]
        System.out.println(newstr.substring(5, 8));             // [5:8)
        // 格式化字符串
        String gsstr = String.format("%s %s", newstr, s);
        System.out.println(gsstr);
        System.out.printf("%s %s%n", newstr, s);
        // 连接字符串
        String ljzfc = newstr+s;
        System.out.println(ljzfc);
        System.out.println(newstr.concat(s));
        System.out.println(String.join("$", newstr, s));
        // 拆分字符串    split(分隔符，分割的份数)
        String exam_split_s = "l-o-v-e-y-o-u";
        String[] splitstr = exam_split_s.split("-", 5);
        System.out.println(Arrays.toString(splitstr));
        // 插入字符串
        StringBuffer cs = new StringBuffer("Hello");
        cs.append("World");
        cs.insert(2, s);
        System.out.println(cs);
        System.out.println(cs.reverse());
        // 填充字符串  Java没有填充功能，一般用format/printf
        // 替换 replace
        String replacestr = s.replace('1', '3');
        System.out.println(replacestr);
        String exam_repl_str = "AE86yyds";
            // 除1-9之外其他都要换成“z“
        System.out.println(exam_repl_str.replaceAll("[^1-9]", "z"));
        // 更改大小写
        System.out.println(newstr.toUpperCase());
        System.out.println(newstr.toLowerCase());
        // 返回索引位置的字符
        System.out.println(newstr.charAt(3));
    }
}
