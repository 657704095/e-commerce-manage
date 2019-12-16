package com.example.eadminprovider.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class MyAnnotation {
    /**
     * 注解类
     *
     * @author suguoliang
     *
     */
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyClassAnnotation {
        String uri();

        String desc();
    }

    /**
     * 构造方法注解
     *
     * @author suguoliang
     *
     */
    @Target(ElementType.CONSTRUCTOR)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyConstructorAnnotation {
        String uri();

        String desc();
    }

    /**
     * 方法注解
     *
     * @author suguoliang
     *
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyMethodAnnotation {
        String uri();

        String desc();
    }

    /**
     * 字段注解
     *
     * @author suguoliang
     *
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyFieldAnnotation {
        String uri();

        String desc();
    }

    /**
     * 可以同时应用到类和方法上
     *
     * @author 尐蘇
     *
     */
    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyClassAndMethodAnnotation {
        // 定义枚举
        public enum EnumType {
            util, entity, service, model
        }

        // 设置默认值
        public EnumType classType() default EnumType.util;

        // 数组
        int[] arr() default { 3, 7, 5 };

        String color() default "blue";
    }

}
