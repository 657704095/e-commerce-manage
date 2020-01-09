package com.example.euserprovider;

import com.example.emodeldao.user.po.TAddress;
import com.example.euserprovider.dao.AddressDao;
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


    @Test
    public <T> void findByProvinceOrCityOrDistrictOrTown(){
        Map<String,Object> addressMap = new HashMap<>();
        TAddress tAddress = new TAddress();

        tAddress.setProvince("四川");
        tAddress.setCity("成都");
        tAddress.setDistrictOrTown("高兴区");

        addressMap.put("TAddress",tAddress);

        addressMap.put("page",0);
        addressMap.put("length",10);

        List<TAddress> tAddresses = addressDao.findByProvinceOrCityOrDistrictOrTown(addressMap);


        for(int i=0;i<tAddresses.size();i++){
            System.out.println(tAddresses.get(i).getProvince());
            System.out.println(tAddresses.get(i).getCity());
            System.out.println(tAddresses.get(i).getDistrictOrTown());
        }


    }

    @Test
    public void fuzzyFindByProvinceOrCityOrDistrictOrTown(){
        Map<String,Object> addressMap = new HashMap<>();
        TAddress tAddress = new TAddress();

        tAddress.setProvince("四川");
        tAddress.setCity("成都");
        tAddress.setDistrictOrTown("高");

        addressMap.put("page",0);
        addressMap.put("length",10);

        addressMap.put("TAddress",tAddress);

        List<TAddress> tAddresses = addressDao.fuzzyFindByProvinceOrCityOrDistrictOrTown(addressMap);

        for(int i=0;i<tAddresses.size();i++){
            System.out.println(tAddresses.get(i).getProvince());
            System.out.println(tAddresses.get(i).getCity());
            System.out.println(tAddresses.get(i).getDistrictOrTown());
        }
    }

    @Test
    public void insertAddress(){
        TAddress tAddress = new TAddress();
        tAddress.setCode("cd1561");
        tAddress.setProvince("四川");
        tAddress.setCity("成都");
        tAddress.setDistrictOrTown("埃尔夫");
        tAddress.setCreationTime("2020-1-9 10:27");

        addressDao.insertAddress(tAddress);


    }

    @Test
    public void updateAddress(){
        Map<String,Object> addressMap = new HashMap<>();
        TAddress tAddress = new TAddress();

        tAddress.setCode("cd15611");
        tAddress.setProvince("四川1");
        tAddress.setCity("成都2");
        tAddress.setDistrictOrTown("埃尔夫3");
        tAddress.setCreationTime("2020-1-9 10:27");
        tAddress.setModifyTime("2020-1-9 10:30");
        tAddress.setId(6);
        tAddress.setModifyId("1");

        addressMap.put("TAddress",tAddress);
        addressDao.updateAddress(addressMap);
    }

    @Test
    public void deleteAddressByIdOrCode(){
        Map<String,Object> addressMap = new HashMap<>();
        TAddress tAddress = new TAddress();

        tAddress.setId(6);

        addressMap.put("TAddress",tAddress);
        addressDao.deleteAddressByIdOrCode(addressMap);
    }
}
