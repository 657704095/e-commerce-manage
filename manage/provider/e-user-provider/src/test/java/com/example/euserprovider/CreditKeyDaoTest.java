package com.example.euserprovider;

import com.example.emodeldao.user.po.TCreditKey;
import com.example.euserprovider.dao.CreditKeyDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

/**
 * 类描述:
 *
 * @author wzq
 * @date 2020/1/7 0007 16:50
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CreditKeyDaoTest {

    @Resource
    private CreditKeyDao creditKeyDao;

    @Test
    public void findById(){
        TCreditKey creditKey = creditKeyDao.findById(3);
        System.out.println();

        System.out.println(creditKey.getKey());
        System.out.println(creditKey.getId());
        System.out.println(creditKey.getCreationTime());
        System.out.println(creditKey.getDel());
    }

    @Test
    public void insert(){
        Map<String,Object> map = new HashMap<>();
        TCreditKey creditKey = new TCreditKey();
        creditKey.setKey("信用18");
        creditKey.setCreationTime("2020-1-7 17:03");
        creditKey.setModifyId("1");
        map.put("TCreditKey",creditKey);

        creditKeyDao.insert(map);
    }

    @Test
    public void update(){
        Map<String,Object> map = new HashMap<>();
        TCreditKey creditKey = new TCreditKey();
        creditKey.setKey("信用123");
        creditKey.setCreationTime("2020-1-7 17:10");
        creditKey.setModifyTime("2020-1-7 17:13");
        creditKey.setModifyId("1");
        creditKey.setId(1);
        map.put("TCreditKey",creditKey);

        creditKeyDao.update(map);
    }

    @Test
    public void del(){
        Map<String,Object> map = new HashMap<>();
        TCreditKey creditKey = new TCreditKey();
        creditKey.setKey("信用123");
        creditKey.setCreationTime("2020-1-7 17:10");
        creditKey.setModifyTime("2020-1-7 17:13");
        creditKey.setModifyId("1");
        creditKey.setId(3);
        creditKey.setDel(1);
        map.put("TCreditKey",creditKey);

        creditKeyDao.del(map);
    }
}
