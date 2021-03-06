package com.example.euserprovider.dao;

import com.example.emodeldao.user.po.TAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 类描述:
 *  地址表的增删改查等基本功能，后期拼合为业务功能
 * @author wzq
 * @date 2019/12/30 0030 16:45
 */
@Mapper
public interface AddressDao {
    /**
     * 通过id查询一个数据,提供mybaits延迟加载使用
     * @param id 查询参数
     * @param <T> 查询参数
     * @return 地址信息
     */
    <T> TAddress findById(int id);

    /**
     * 查询语句 精确查询
     * @param addressMap 地址对象
     * @return 地区集合
     */
    <T> List<TAddress> findByProvinceOrCityOrDistrictOrTown(Map<String,T> addressMap);

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
     * 修改数据
     * @param addressMap 数据
     * @param <T> 数据
     * @return 条数
     */
    <T>int updateAddress(Map<String,T> addressMap);

    /**
     * 删除通过id或者code
     * @param addressMap 集合
     * @param <T> 地址或者code
     * @return 删除条数
     */
    <T> int deleteAddressByIdOrCode(Map<String,T> addressMap);
}
