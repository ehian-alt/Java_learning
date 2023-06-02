package exam;

import java.util.Scanner;
public class Scanner_ {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        // 从键盘接收数据
//
//        // next方式接收字符串
//        System.out.println("next方式接收：");
//        // 判断是否还有输入
//        if (scan.hasNext()) {
//            String str1 = scan.next();
//            System.out.println("输入的数据为：" + str1);
//        }
//        scan.nextLine();
//        // nextLine方式接收字符串
//        System.out.println("nextLine方式接收：");
//        // 判断是否还有输入
//        if (scan.hasNextLine()) {
//            String str2 = scan.nextLine();
//            System.out.println("输入的数据为：" + str2);
//        }
//        scan.close();

        System.out.println("请输入数字：");
        Scanner scan = new Scanner(System.in);

        double sum = 0;
        int m = 0;

        while (scan.hasNextDouble()) {
            double x = scan.nextDouble();
            m = m + 1;
            sum = sum + x;
        }

        System.out.println(m + "个数的和为" + sum);
        System.out.println(m + "个数的平均值是" + (sum / m));
        scan.close();
    }
}