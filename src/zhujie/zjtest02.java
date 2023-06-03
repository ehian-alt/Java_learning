package zhujie;

import java.lang.annotation.*;

// 测试元注解 （自定义注解）
public class zjtest02 {
    @MyAnnotation
    public void test(){
    }
}

// @Retention 表示在什么时候有效(RUNTIME>CLASS>SOURCES)
@Retention(RetentionPolicy.RUNTIME)
// @Target 表示自定义注解能对谁用(参数是一个枚举类型)
@Target({ElementType.METHOD, ElementType.TYPE})
// @Documented 表示是否将自定义注解生成在JAVA doc中
@Documented
// @Inherited 表示子类可继承父类的注解
@interface MyAnnotation{
}



