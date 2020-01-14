package com.example.ewaybillprovide.dao;

import com.example.emodeldao.merchant.po.TWaybill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 类描述:
 *
 * @author wzq
 * @date 2020/1/14 0014 14:05
 */
@Mapper
public interface WaybillDao {
    /**
     *
     * @param t 运单
     * @param <T> 模板
     * @return 数据
     */
    <T>List<TWaybill> find(Map<String,T> t);

    /**
     *
     * @param id id
     * @return t
     */
    TWaybill findById(int id);

    /**
     * 插入数据
     * @param t 数据
     * @param <T> 模板
     * @return 条数
     */
    <T>int insert(Map<String,T> t);

    /**
     * 修改数据
     * @param t 数据
     * @param <T> 模板
     * @return 条数
     */
    <T>int update(Map<String,T> t);

    /**
     * 删除数据
     * @param t 数据
     * @param <T> 模板
     * @return 条数
     */
    <T>int del(Map<String,T> t);
}
