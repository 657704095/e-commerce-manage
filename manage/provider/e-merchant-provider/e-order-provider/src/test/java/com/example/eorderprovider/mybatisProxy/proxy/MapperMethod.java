package com.example.eorderprovider.mybatisProxy.proxy;

/**
 * 类描述:
 *
 * @author wzq
 * @date 2020/1/14 0014 16:12
 */
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MapperMethod {

    private final Method method;
    private final MapperProxy mapperProxy;

    public MapperMethod(Method method, MapperProxy mapperProxy) {
        this.method = method;
        this.mapperProxy = mapperProxy;
    }

    /**
     *
     * @param args 参数
     * @param mapperInterface 为了拿原类名
     * @param <T> 模板
     * @return 代理对象
     */
    public <T> Object execute(Object[] args,Class<T> mapperInterface){
        System.out.println("==========MapperProxy: " + mapperProxy.getClass().getName());
        System.out.println("name: ====execute method {" + method.getName() + "}" );

        // 读取mapper.xml中的语句块，并将其作为SqlStatement执行，
        // 方法名获取sql语句，参数通过代理的Invocation等获得
        // 有注解则处理注解中的参数

        // 此处只是简单的模拟一下
        //oldRealizeMethod(args);

        //xml中用dao名，拿到后和代理对象名相比，如果相同继续执行下一步判断
        String className = "com.example.eorderprovider.mybatisProxy.dao.UserDao";//模拟读取出来的类名
        // 模拟的类名必须一定是全名，因为获得类名就是全名，不用全名无法区分唯一对象

        //但是现在有个问题，我不知道怎么拿到原来的类名,通过注入拿到原类名
        if(mapperInterface.getName().equals(className)){
            //xml中的方法名，拿到后和代理对象的方法名对比，如果相同继续执行
            String methodName = "add";//模拟读取出来的方法名
            if(method.getName().equals(methodName)){
                //拿出xml中sql语句执行
                String sql = "inset user set id = 1,name = skyName,pwd = 159357";//模拟读取出来的sql语句
                System.out.println(sql);
            }
        }

        return 1;
    }

    /**
     * 以前的实现方法
     * @param args 参数
     */
    private void oldRealizeMethod(Object[] args){
        // 此处只是简单的模拟一下
        final Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            Class<? extends Annotation> aClass = annotation.annotationType();
            if (aClass.equals(Insert.class)) {
                System.out.println("execute insert {" + args[0] + "} completed");
                System.out.println("重写方法！");
                //重写方法的确可以，但是任然有问题，问题就是，userDao和orderDao的方法肯定是不一样的。

                //xml中用dao名，拿到后和代理对象名相比，如果相同继续执行下一步判断

                //xml中的方法名，拿到后和代理对象的方法名对比，如果相同继续执行

                //拿出xml中sql语句执行
            }
            if (aClass.equals(Update.class)) {
                System.out.println("execute update {" + args[0] + "} completed");
            }
        }
    }
}