package com.example.euserprovider;

import com.example.emodeldao.user.po.TAddress;
import com.example.emodeldao.user.po.TAddressMinute;
import com.example.euserprovider.dao.AddressMinuteDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressMinuteDaoTest {

    @Resource
    private AddressMinuteDao addressMinuteDao;


    /**
     * 测试类必须是公开的，否则方法无法被调用
     */
    @Test
    public void find(){
        Map<String,Object> address = new HashMap<>();
        TAddressMinute tAddressMinute = new TAddressMinute();
        TAddress tAddress = new TAddress();

        tAddress.setId(1);

        tAddressMinute.setTAddressId(tAddress);

        address.put("TAddressMinute",tAddressMinute);
        address.put("page",0);
        address.put("length",10);

        List<TAddressMinute> addressMinutes = addressMinuteDao.findByAddressIdOrUserId(address);

        System.out.println(addressMinutes.get(0).getConcretenessAddress());
        System.out.println(addressMinutes.get(0).getModifyIdType());
        System.out.println(addressMinutes.get(0).getModifyId());

        System.out.println(addressMinutes.get(0).getUserId().getUserName());

        System.out.println(addressMinutes.get(0).getTAddressId().getCity());
    }



}
