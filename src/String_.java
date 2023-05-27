import java.util.Arrays;

public class String_ {
    public static void main(String[] args){
        char[] char_Array = {'H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd'};
        String exam_String = new String(char_Array);
//        System.out.println(exam_String.charAt(0));
//        System.out.println(exam_String.compareTo("Hello"));
//        System.out.println(exam_String.compareTo("hellohorld"));
//        System.out.println(exam_String.compareToIgnoreCase("helloworld"));
//        String str = " Java ";
//        System.out.println(str.concat(str));
//        System.out.println(exam_String.isEmpty());
//        System.out.println(str.trim());
//        System.out.println(str.length());
//        String new_s1 = String.copyValueOf(char_Array);
//        System.out.println(new_s1);
//        String new_s2 = String.copyValueOf(char_Array, 2, 6);
//        System.out.println(new_s2);
//        System.out.println(exam_String.indexOf('l'));
//        System.out.println(exam_String.indexOf('l', 4));
//        System.out.println(exam_String.indexOf("or"));
//        System.out.println(exam_String.lastIndexOf('l'));
//        System.out.println(exam_String.lastIndexOf('l', 7));
//        System.out.println(exam_String.toLowerCase());
//        System.out.println(exam_String.toUpperCase());
//        System.out.println(exam_String.substring(5));
//        System.out.println(exam_String.substring(0, 5));
//        // 拆分字符串    split(分隔符，分割的份数)
//        String exam_split_s = "l-o-v-e-y-o-u";
//        String[] split_str = exam_split_s.split("-", 5);
//        System.out.println(Arrays.toString(split_str));
        String s = "hello";
        System.out.println(s.replace('l', 'r'));
        char[] ca = s.toCharArray();
        for (char ch : ca){
            System.out.println(ch);
        }
    }
}
