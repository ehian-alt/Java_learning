package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ArrayList_ {
    public static void main(String[] args){
//        ArrayList<String> sList = new ArrayList<String>();
//        sList.add("Hello");
//        sList.add("World");
//        sList.add("Java");
//        sList.add("learning");
//        ArrayList<String> nList = (ArrayList<String>) sList.clone();
//        sList.addAll(nList);
//        for (String s : sList){
//            System.out.println("sList中的元素:" + s);
//        }
//        nList.clear();
//        System.out.println("nList.clear()后的字符串形式" + nList.toString());
//        System.out.println(sList.contains("World"));
//        System.out.println(sList.indexOf("World"));
//        System.out.println(sList.get(0));
//        System.out.println(sList.remove(0));
//        System.out.println(sList.size());
//        System.out.println(sList.isEmpty());
//        System.out.println(sList.subList(1, 2));
//        sList.set(1, "github");
//        System.out.println("替换之后:" + sList.toString());
//        sList.sort(Comparator.reverseOrder());
//        System.out.println("倒序排序之后:" + sList);
//        String[] sArr = new String[sList.size()];
//        sList.toArray(sArr);
//        System.out.println("sArr:" +Arrays.toString(sArr));
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
