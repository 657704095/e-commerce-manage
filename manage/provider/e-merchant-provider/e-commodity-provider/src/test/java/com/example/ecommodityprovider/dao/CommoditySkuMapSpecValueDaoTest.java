package com.example.ecommodityprovider.dao;

import com.example.emodeldao.commodity.po.CommoditySku;
import com.example.emodeldao.commodity.po.CommoditySkuMapSpecValue;
import com.example.emodeldao.commodity.po.CommoditySpecValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * 类描述:
 *
 * @author wzq
 * @date 2020/1/16 0016 17:04
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CommoditySkuMapSpecValueDaoTest {

    @Resource
    private CommoditySkuMapSpecValueDao commoditySkuMapSpecValueDao;

    @Test
    public void find(){
        Map<String,Object> map = new HashMap<>();
        CommoditySkuMapSpecValue commoditySkuMapSpecValue = new CommoditySkuMapSpecValue();

        CommoditySku commoditySku = new CommoditySku();
        commoditySku.setId(1);
        commoditySkuMapSpecValue.setSkuId(commoditySku);

        map.put("CommoditySkuMapSpecValue",commoditySkuMapSpecValue);

        map.put("page",0);
        map.put("length",10);
        List<CommoditySkuMapSpecValue> commoditySkuMapSpecValues = commoditySkuMapSpecValueDao.find(map);

        System.out.println(commoditySkuMapSpecValues.get(0).getSpecValueId().getSpecValue());
    }

    @Test
    public void findById(){
        CommoditySkuMapSpecValue commoditySkuMapSpecValue = commoditySkuMapSpecValueDao.findById(1);
        System.out.println(commoditySkuMapSpecValue.getSpecValueId().getSpecValue());
    }

    @Test
    public void insert(){
        Map<String,Object> map = new HashMap<>();
        CommoditySkuMapSpecValue commoditySkuMapSpecValue = commoditySkuMapSpecValueDao.findById(1);
        map.put("CommoditySkuMapSpecValue",commoditySkuMapSpecValue);

        commoditySkuMapSpecValueDao.insert(map);
    }

    @Test
    public void update(){
        Map<String,Object> map = new HashMap<>();
        CommoditySkuMapSpecValue commoditySkuMapSpecValue = commoditySkuMapSpecValueDao.findById(1);
        CommoditySpecValue commoditySpecValue = new CommoditySpecValue();
        commoditySpecValue.setId(2);
        commoditySkuMapSpecValue.setSpecValueId(commoditySpecValue);
        map.put("CommoditySkuMapSpecValue",commoditySkuMapSpecValue);

        commoditySkuMapSpecValueDao.update(map);
    }

    @Test
    public void del(){
        Map<String,Object> map = new HashMap<>();
        CommoditySkuMapSpecValue commoditySkuMapSpecValue = commoditySkuMapSpecValueDao.findById(1);
        commoditySkuMapSpecValue.setDel(15);
        map.put("CommoditySkuMapSpecValue",commoditySkuMapSpecValue);

        commoditySkuMapSpecValueDao.del(map);
    }
}
