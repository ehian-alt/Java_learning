package days;

import java.util.Scanner;

interface Shape{
    private void Draw(){}
    private void Erase(){}
    private void Move(){}
}
class Point implements Shape{
    int x, y;
    public Point(int a, int b){
        this.x = a;
        this.y = b;
    }
}
enum Ccolor {red, yellow, green, gray, black}
class Line implements Shape{
    Ccolor color;
    Point p1, p2;
    public void Draw(){
        System.out.println("Draw a days.Line");
    }
    public double Length(){
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
    }
    public Line(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

}
class Triangle implements Shape{
    Point p1, p2, p3;
    public double Area(){
        Line l1 = new Line(p1, p2);
        Line l2 = new Line(p1, p3);
        Line l3 = new Line(p2, p3);
        System.out.println(l1.Length() + " " + l2.Length() + " " + l3.Length());
        double s = (l1.Length()+l2.Length()+l3.Length())/2;
        return Math.sqrt(s*(s-l1.Length())*(s-l2.Length())*(s-l3.Length()));
    }
    public Triangle(Point p1, Point p2, Point p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
}
class Quadrilateral implements Shape{
    Point p1, p2, p3, p4;

    public Quadrilateral() {

    }

    public  double Area(){
        return 0;
    }
    public Quadrilateral(Point p1, Point p2, Point p3, Point p4){

    }
}
class Square extends Quadrilateral{
    public Square(Point p1, Point p2, Point p3, Point p4){
        System.out.println();
    }
}
class Circle implements Shape{
    int r;
    Point p;
    public double Area(){
        return Math.PI*r*r;
    }
    public Circle(Point p, int r){
        this.p = p;
        this.r = r;
    }

}
public class day3 {
    public static Point get_p(){
        Scanner scan = new Scanner(System.in);
        int a, b;
        System.out.println("请输入坐标 用空格分割");
        String s = scan.nextLine();
        a = Integer.parseInt(s.split(" ")[0]);
        b = Integer.parseInt(s.split(" ")[1]);
        return new Point(a, b);
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("1:三角形\t2:圆\t3:四边形\n画个什么？:");
        int sele = scan.nextInt();
        switch (sele) {
            case 1 -> {
                Triangle t = new Triangle(get_p(), get_p(), get_p());
                System.out.printf("这个三角形的面积为:%f", t.Area());
            }
            case 2 -> {
                System.out.print("请输入圆的半径:");
                int r = scan.nextInt();
                Circle c = new Circle(get_p(), r);
                System.out.printf("这个圆的面积为:%f", c.Area());
            }
            case 3 -> {
                Quadrilateral qua = new Quadrilateral(get_p(), get_p(), get_p(), get_p());
                System.out.printf("这个四边形的面积为:%f", qua.Area());
            }
            default -> {
                System.out.println("输入有误！");
            }
        }
    }
}
