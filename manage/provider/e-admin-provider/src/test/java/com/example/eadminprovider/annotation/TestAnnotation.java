package com.example.eadminprovider.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


@MyAnnotation.MyClassAnnotation(desc = "The Class", uri = "com.sgl.annotation")
@MyAnnotation.MyClassAndMethodAnnotation(classType = MyAnnotation.MyClassAndMethodAnnotation.EnumType.util)
public class TestAnnotation {
    @MyAnnotation.MyFieldAnnotation(desc = "The Class Field", uri = "com.sgl.annotation#id")
    private String id = "id为181121";

    @MyAnnotation.MyConstructorAnnotation(desc = "The Class Constructor", uri = "com.sgl.annotation#constructor")
    public TestAnnotation() {
    }

    public String getId() {
        return id;
    }

    @MyAnnotation.MyMethodAnnotation(desc = "The Class Method", uri = "com.sgl.annotation#setId")
    public void setId(String id) {
        this.id = id;
    }

    @MyAnnotation.MyMethodAnnotation(desc = "The Class Method sayHello", uri = "com.sgl.annotation#sayHello")
    public void sayHello(String name) {
        if (name == null || name.equals("")) {
            System.out.println("hello world!");
        } else {
            System.out.println(name + "\t:say hello world");
        }
    }

}

class Main{

    public static void main(String[] args) throws Exception {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        // 获取类注解
        MyAnnotation.MyClassAnnotation myClassAnnotation = clazz.getAnnotation(MyAnnotation.MyClassAnnotation.class);
        System.out.println(myClassAnnotation.desc() + "+" + myClassAnnotation.uri());

        // 获得构造方法注解
        Constructor<TestAnnotation> constructors = clazz.getConstructor(new Class[] {});// 先获得构造方法对象
        MyAnnotation.MyConstructorAnnotation myConstructorAnnotation = constructors.getAnnotation(MyAnnotation.MyConstructorAnnotation.class);// 拿到构造方法上面的注解实例
        System.out.println(myConstructorAnnotation.desc() + "+" + myConstructorAnnotation.uri());

        // 获得方法注解
        Method method = clazz.getMethod("setId", new Class[] { String.class });// 获得方法对象
        MyAnnotation.MyMethodAnnotation myMethodAnnotation = method.getAnnotation(MyAnnotation.MyMethodAnnotation.class);
        System.out.println(myMethodAnnotation.desc() + "+" + myMethodAnnotation.uri());

        // 获得字段注解
        Field field = clazz.getDeclaredField("id");// 暴力获取private修饰的成员变量
        field.setAccessible(true);
        MyAnnotation.MyFieldAnnotation myFieldAnnotation = field.getAnnotation(MyAnnotation.MyFieldAnnotation.class);
        System.out.println(myFieldAnnotation.desc() + "+" + myFieldAnnotation.uri());


        TestAnnotation testAnnotation = new TestAnnotation();
        Object obj = field.get(testAnnotation);
        String id = (String)obj;
        System.out.println(id);
    }
}