package com.example.ecommodityprovider.dao;

import com.example.emodeldao.commodity.po.CommoditySku;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 类描述:
 *
 * @author wzq
 * @date 2020/1/16 0016 13:37
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CommoditySkuDaoTest {

    @Resource
    private CommoditySkuDao commoditySkuDao;

    @Test
    public void find(){

    }

    @Test
    public void findById(){
        //CommoditySku commoditySku = commoditySkuDao.findById(1);
        //System.out.println(commoditySku.getSkuName());
    }

    @Test
    public void insert(){

    }

    @Test
    public void update(){

    }

    @Test
    public void del(){

    }
}
