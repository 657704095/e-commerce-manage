package com.example.eadminconsumer.service.impl;

import com.example.eadminconsumer.Fegin.AdminDaoFegin;
import com.example.eadminconsumer.service.AdminFeginConsumer;
import com.example.emodeldao.admin.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * 业务层方法实现
 * @author wzq
 */
@Service
@Slf4j
public class AdminFeginConsumerImpl implements AdminFeginConsumer {

    @Autowired
    private AdminDaoFegin adminDaoFegin;

    @Override
    public Admin findByIdOrAdminName(Admin admin) {
        log.info("查询业务层中接受的对象为:{}",admin);
        return adminDaoFegin.findByIdOrAdminName(admin);
    }

    @Override
    public Admin fingById(Admin admin){
        log.info("id查询业务层中接受的对象为:{}",admin);
        return adminDaoFegin.fingById(admin);
    }

    @Override
    public int insert(Admin admin) {
        log.info("插入业务层中接受的对象为:{}",admin);
        return adminDaoFegin.insert(admin);
    }

    @Override
    public int upmodify(Admin admin){
        log.info("修改业务层中接受的对象为:{}",admin);
        return adminDaoFegin.upmodify(admin);
    }
}
