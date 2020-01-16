package com.example.euserprovider;

import com.example.emodeldao.user.po.TCreditKey;
import com.example.emodeldao.user.po.TCreditValue;
import com.example.emodeldao.user.po.User;
import com.example.euserprovider.dao.CreditValueDao;
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
 * @date 2020/1/7 0007 16:51
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CreditValueDaoTest {

    @Resource
    private CreditValueDao creditValueDao;

    @Test
    public void findByCreditIdOrUserId(){
        Map<String,Object> map = new HashMap<>();
        TCreditValue creditValue = new TCreditValue();

        TCreditKey creditKey = new TCreditKey();
        creditKey.setId(1);
        creditValue.setTCreditId(creditKey);

        User user = new User();
        user.setId(1);
        creditValue.setUserId(user);

        map.put("TCreditValue",creditValue);

        map.put("page",0);
        map.put("length",10);

        List<TCreditValue> creditValues = creditValueDao.findByCreditIdOrUserId(map);

        for(int i=0;i<creditValues.size();i++){
            System.out.println(creditValues.get(i).getUserId().getUserNickName());
            System.out.println(creditValues.get(i).getTCreditId().getKey());
            System.out.println(creditValues.get(i).getValue());
        }
    }

    @Test
    public void findById(){
        TCreditValue tCreditValue = creditValueDao.findById(1);
        System.out.println(tCreditValue.getValue());
    }

    @Test
    public void insert(){
        System.out.println();

        Map<String,Object> map = new HashMap<>();
        TCreditValue creditValue = new TCreditValue();

        TCreditKey creditKey = new TCreditKey();
        creditKey.setId(1);
        creditValue.setTCreditId(creditKey);

        User user = new User();
        user.setId(1);
        creditValue.setUserId(user);


        creditValue.setValue("95959");
        creditValue.setCreationTime("2020-1-7 17:57");
        creditValue.setModifyId("1");


        map.put("TCreditValue",creditValue);

        creditValueDao.insert(map);
    }

    @Test
    public void update(){
        System.out.println();

        System.out.println();

        Map<String,Object> map = new HashMap<>();
        TCreditValue creditValue = new TCreditValue();

        TCreditKey creditKey = new TCreditKey();
        creditKey.setId(1);
        creditValue.setTCreditId(creditKey);

        User user = new User();
        user.setId(1);
        creditValue.setUserId(user);


        creditValue.setValue("15");
        creditValue.setCreationTime("2020-1-7 17:57");
        creditValue.setModifyTime("2020-1-7 18:03");
        creditValue.setModifyId("1");

        creditValue.setId(4);

        map.put("TCreditValue",creditValue);


        creditValueDao.update(map);
    }

    @Test
    public void del(){
        System.out.println();
        Map<String,Object> map = new HashMap<>();
        TCreditValue creditValue = new TCreditValue();

        creditValue.setId(1);
        creditValue.setDel(1);
        map.put("TCreditValue",creditValue);

        creditValueDao.del(map);
    }
}
