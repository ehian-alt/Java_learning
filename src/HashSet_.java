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
