package com.example.euserprovider.dao;

import com.example.emodeldao.user.po.TAddressMinute;

import java.util.List;
import java.util.Map;

/**
 * 类描述:
 *  地址表详情表的增删改查等基本功能，后期拼合为业务功能
 * @author wzq
 * @date 2019/12/30 0030 16:47
 */
public interface AddressMinuteDao {
    /**
     *  查询一个地址详情表，通过addressId
     * @param addressMinute 地址详细信息，以及分页信息
     * @param <T> 分页和查询参数
     * @return 对应的所有数据集合
     */
    <T> List<TAddressMinute> findByAddressIdOrUserId(Map<String,T> addressMinute);

    /**
     * 插入一条数据
     * @param tAddressMinute 地址信息
     * @return 插入个数
     */
    int insertAddressMinute(TAddressMinute tAddressMinute);

    /**
     * 修改数据,通过用户id
     * 也就是修改对应用户的地址详情数据
     *
     * 修改地址基本，省，市，镇，需要在业务层拼合逻辑。
     * 修改，地址信息的逻辑为，用修改的信息去地址表查询，如果有数据，更换外键指向
     * 如果没有地址添加信息，指向新的外键
     * @param tAddressMinute 地址详情
     * @return 修改条数
     */
    int updateAddressMuinteByUserId(TAddressMinute tAddressMinute);

    /**
     * 给用户提供的删除功能，并非真的删除
     * @param tAddressMinute 地址
     * @return 修改个数
     */
    int del(TAddressMinute tAddressMinute);
}
