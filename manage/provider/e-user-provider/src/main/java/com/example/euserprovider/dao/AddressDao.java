package com.example.euserprovider.dao;

import com.example.emodeldao.user.po.TAddress;

import java.util.List;
import java.util.Map;

/**
 * 类描述:
 *  地址表的增删改查等基本功能，后期拼合为业务功能
 * @author wzq
 * @date 2019/12/30 0030 16:45
 */
public interface AddressDao {
    /**
     * 查询语句 精确查询
     * @param addressMap 地址对象
     * @return 地区集合
     */
    List<TAddress> findByProvinceOrCityOrDistrictOrTown(Map<String,TAddress> addressMap);

    /**
     * 查询语句 模糊查询
     * @param addressMap 地址对象
     * @return 地区集合
     */
    <T> List<TAddress> fuzzyFindByProvinceOrCityOrDistrictOrTown(Map<String,T> addressMap);

    /**
     * 插入一条数据
     * @param address 地址对象
     * @return 插入数
     */
    int insertAddress(TAddress address);

    /**
     * 删除通过id或者code
     * @param addressMap 集合
     * @param <T> 地址或者code
     * @return 删除条数
     */
    <T> int deleteAddressByIdOrCode(Map<String,T> addressMap);
}
