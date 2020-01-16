package com.example.ecommodityprovider.dao;

import com.example.emodeldao.commodity.po.CommoditySku;
import com.example.emodeldao.commodity.po.CommoditySpu;
import com.example.emodeldao.merchant.po.TMerchant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String,Object> map = new HashMap<>();
        CommoditySku commoditySku = new CommoditySku();
        //commoditySku.setSkuNo(15615);
        //commoditySku.setSkuName("15");

        CommoditySpu commoditySpu = new CommoditySpu();
        commoditySpu.setId(1);
        commoditySku.setSpuId(commoditySpu);

        TMerchant tMerchant = new TMerchant();
        tMerchant.setId(1);
        //commoditySku.setMerchantId(tMerchant);

        map.put("CommoditySku",commoditySku);

        map.put("page",0);
        map.put("length",10);
        List<CommoditySku> commoditySkus = commoditySkuDao.find(map);

        System.out.println(commoditySkus.get(0).getSkuName());
    }

    @Test
    public void findById(){
        CommoditySku commoditySku = commoditySkuDao.findById(1);
        System.out.println(commoditySku.getSkuName());
    }

    @Test
    public void insert(){
        Map<String,Object> map = new HashMap<>();
        CommoditySku commoditySku = commoditySkuDao.findById(1);

        commoditySku.setSkuNo(151651514);

        map.put("CommoditySku",commoditySku);

        commoditySkuDao.insert(map);
    }

    @Test
    public void update(){
        Map<String,Object> map = new HashMap<>();
        CommoditySku commoditySku = commoditySkuDao.findById(1);

        commoditySku.setSkuName("小优游戏卡");

        map.put("CommoditySku",commoditySku);

        commoditySkuDao.update(map);
    }

    @Test
    public void del(){
        Map<String,Object> map = new HashMap<>();
        CommoditySku commoditySku = commoditySkuDao.findById(1);
        commoditySku.setDel(1);
        commoditySku.setSkuNo(15615);
        map.put("CommoditySku",commoditySku);
        int i = commoditySkuDao.del(map);
        System.out.println(i);
    }
}
