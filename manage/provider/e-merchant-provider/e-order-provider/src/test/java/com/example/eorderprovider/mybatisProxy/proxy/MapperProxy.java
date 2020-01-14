package com.example.eorderprovider.mybatisProxy.proxy;

/**
 * 类描述:
 *
 * @author wzq
 * @date 2020/1/14 0014 16:11
 */
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class MapperProxy<T> implements InvocationHandler, Serializable {

    private final Class<T> mapperInterface;
    private final Map<Method, MapperMethod> methodCache;

    public MapperProxy(Class<T> mapperInterface, Map<Method, MapperMethod> methodCache) {
        this.mapperInterface = mapperInterface;
        this.methodCache = methodCache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            try {
                return method.invoke(this, args);
            } catch (Throwable t) {

            }
        }
        final MapperMethod mapperMethod = cachedMapperMethod(method);

        return mapperMethod.execute(args,mapperInterface);
    }

    private MapperMethod cachedMapperMethod(Method method) {
        MapperMethod mapperMethod = methodCache.get(method);
        if (mapperMethod == null) {
            mapperMethod = new MapperMethod(method, this);
            methodCache.put(method, mapperMethod);
        }
        return mapperMethod;
    }
}