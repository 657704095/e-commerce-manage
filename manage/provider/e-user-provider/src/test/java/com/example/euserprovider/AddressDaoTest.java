package com.example.euserprovider;

import com.example.emodeldao.user.po.TAddress;
import com.example.euserprovider.dao.AddressDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 类描述:
 *
 * @author wzq
 * @date 2020/1/7 0007 9:54
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressDaoTest {

    @Resource
    private AddressDao addressDao;

    @Test
    public void findById(){

        TAddress tAddress = addressDao.findById(1);

        System.out.println(tAddress.getCity());
        System.out.println(tAddress.getProvince());
        System.out.println(tAddress.getDistrictOrTown());
    }
}
