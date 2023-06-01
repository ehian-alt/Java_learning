import java.awt.desktop.SystemSleepEvent;
import java.util.HashMap;

public class HashMap_ {
    public static void main(String[] args){
        HashMap<String, Integer> dic = new HashMap<>();
//        dic.put("Hello", 1);
//        dic.put("World", 2);
//        dic.put("Java", 0);
//        dic.put("learning", 4);
//        System.out.println(dic.size());
//        dic.clear();
//        System.out.println(dic.isEmpty());
//        dic.putIfAbsent("Hello", 5);
//        System.out.println(dic.containsKey("Hello"));
//        System.out.println(dic.containsValue(5));
//        dic.replace("Hello", 8);
//        System.out.println(dic.get("Hello"));
//        dic.forEach((key, value)->{
//            value = value * 2;
//            System.out.println(key+ ":" + value);
//        });
        dic.merge("Hello", 1, (oldValue, newValue) -> oldValue+1);
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
