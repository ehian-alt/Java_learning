package exam;

import java.util.Arrays;

public class Array_ {
    public static void main(String[] args){
        // 用索引遍历
        char[] ch_array = {'h', 'e', 'l', 'l', 'o'};
        for ( int i = 0; i < ch_array.length; i++ ){
            System.out.print(ch_array[i] + " ");
        }
        System.out.println();
        // foreach 遍历
        for (char c: ch_array) {
            System.out.print(c + " ");
        }
        System.out.println();
        String[][] s = new String[2][];
        s[0] = new String[2];
        s[1] = new String[3];
        System.out.println(s[0].length + " " + s[1].length);
        // fill
        int[] intArray = new int[5];
        Arrays.fill(intArray, 0);
        System.out.println(Arrays.toString(intArray));
        // sort
        int[] intArray_2 = {1, 3, 2, 6, 4, 4, 5};
        Arrays.sort(intArray_2);
        System.out.println(Arrays.toString(intArray_2));
        // equals
        System.out.println(Arrays.equals(intArray, intArray_2));
        // binarySearch
        System.out.println(Arrays.binarySearch(intArray_2, 4));
    }
}
