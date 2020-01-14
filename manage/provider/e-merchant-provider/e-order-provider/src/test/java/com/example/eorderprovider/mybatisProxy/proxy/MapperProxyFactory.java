package com.example.eorderprovider.mybatisProxy.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * 类描述:
 *
 * @author wzq
 * @date 2020/1/14 0014 16:10
 */
public class MapperProxyFactory<T> {
    private final Class<T> mapperInterface;
    private final Map<Method, MapperMethod> methodCache = new ConcurrentHashMap<>();

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
        //mapperInterface通过这个接口注入类，自然用这个对象可以拿到类方法
        //System.out.println("类名:"+mapperInterface.getName());
    }

    public Class<T> getMapperInterface() {
        return mapperInterface;
    }

    public Map<Method, MapperMethod> getMethodCache() {
        return methodCache;
    }

    protected T newInstance(MapperProxy<T> mapperProxy){
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }

    public T newInstance(){
        final MapperProxy<T> mapperProxy = new MapperProxy<>(mapperInterface, methodCache);
        return newInstance(mapperProxy);
    }
}
