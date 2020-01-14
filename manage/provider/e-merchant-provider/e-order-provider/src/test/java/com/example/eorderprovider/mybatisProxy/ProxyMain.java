package com.example.eorderprovider.mybatisProxy;

import com.example.eorderprovider.mybatisProxy.dao.OrderDao;
import com.example.eorderprovider.mybatisProxy.dao.UserDao;
import com.example.eorderprovider.mybatisProxy.proxy.MapperProxyFactory;

/**
 * 类描述:
 *
 * @author wzq
 * @date 2020/1/14 0014 16:12
 */
public class ProxyMain {

    public static void main(String[] args) {
        System.out.println("========================实例化UserDao的代理工厂========================");
        MapperProxyFactory<UserDao> userDaoProxyFactory = new MapperProxyFactory<>(UserDao.class);

        UserDao target = userDaoProxyFactory.newInstance();
        System.out.println(target);

        target.add("chinoukin");

        target.update("chenyingqin");

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("========================实例化OrderDao的代理工厂=========================");
        MapperProxyFactory<OrderDao> OrderDaoProxyFactory = new MapperProxyFactory<>(OrderDao.class);

        OrderDao target1 = OrderDaoProxyFactory.newInstance();
        System.out.println(target1);

        target1.add("订单1");

        target1.update("订单xxxx");


    }
}