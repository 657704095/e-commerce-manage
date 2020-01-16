package com.example.ecommodityprovider.dao;

import com.example.emodeldao.merchant.po.TMerchant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 类描述:
 *
 * @author wzq
 * @date 2020/1/16 0016 15:53
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TMerchantDaoTest {
    @Resource
    private TMerchantDao tMerchantDao;

    @Test
    public void findById(){
        TMerchant tMerchant = tMerchantDao.findById(1);
        System.out.println(tMerchant.getName());
    }
}
