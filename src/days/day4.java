package days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class day4 {
    public static void main(String[] args){
        String[] sarr = {"k", "i", "s", "s"};
        String[] examstr = {"h", "e", "l", "l", "o"};
        List<String> LString = new ArrayList<>();
        LString.add("ddv");
        LString.add(0, "hhh");
        for (String s : LString){
            System.out.println(s);
        }
        // 判断某个元素是否在List中，返回值是bool类型的
        System.out.println(LString.contains("hhh"));
        // 移除List中的值
        LString.remove("hhh");
        System.out.println("移除List中的值:"+ LString.toString());
        // 获取某个索引的值
        String ts = LString.get(0);
        System.out.println(ts);
        // 获取List大小
        int siz = LString.size();
        System.out.println(siz);
        // 返回值在List中的位置
        System.out.println(LString.indexOf("ddv"));
        // 清空List
        LString.clear();

    }
}
