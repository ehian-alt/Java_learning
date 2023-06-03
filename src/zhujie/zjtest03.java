package zhujie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 自定义一个注解
public class zjtest03 {

    @zdyAnnotation(name = "Annotation")
    public static void test(){}
    public static void main(String[] args) {

    }
}
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface zdyAnnotation{
    // 注解的参数: 参数类型 + 参数名();
    // 参数名后一定要括号
    String name();
    // 注解的参数可以定义默认值 default 没有传参数就用默认值
    int id() default -1;
    int age() default 0;
}


