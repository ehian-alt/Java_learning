package zhujie;

public class zjtest01 {

    // 重写的注解
    @Override
    public String toString() {
        return "zjtest01{}";
    }

    //@Deprecated 不推荐使用的，但是可以使用，或者存在更好的方式
    @Deprecated
    @SuppressWarnings("all")    // 镇压警告
    public static void deMeth(){
        System.out.println("Deprecated");
    }
    public static void main(String[] args) {
        deMeth();
    }
}
