public class day1 {
    public static void print_arr(int[] Arr){
        for (int i: Arr) {
            System.out.print(i);
        }
    }
    public static void bubble_sort(int[] Arr){
        int n = Arr.length;
        for (int i = 0; i < n; i++){
            for (int j = n-1; j>i; j--){
                if (Arr[j] < Arr[j-1]){
                    int tmp = Arr[j];
                    Arr[j] = Arr[j-1];
                    Arr[j-1] = tmp;
                }
            }
        }
        print_arr(Arr);
        System.out.println();
    }
    public static void xuanze_sort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            int tmp = arr[i], index = i;
            for (int j = n-1; j > i; j--){
                if (arr[j] < tmp){
                    index = j;
                    tmp = arr[j];
                }
            }
            arr[index] = arr[i];
            arr[i] = tmp;
        }
        print_arr(arr);
        System.out.println();
    }
    public static void Insert_sort(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int num = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (num < arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = num;
                }
            }
        }
        print_arr(arr);
        System.out.println();
    }
    public static void main(String[] args){
        int[] nums = {12,43,2,34,87,54,32,16,67,49};
        System.out.println("1:冒泡排序\n2:选择排序\n3:插入排序\n请选择:");
        bubble_sort(nums);
        xuanze_sort(nums);
        Insert_sort(nums);
    }
}
