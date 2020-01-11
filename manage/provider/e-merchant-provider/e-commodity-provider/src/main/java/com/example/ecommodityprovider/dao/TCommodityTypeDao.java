package com.example.ecommodityprovider.dao;

import com.example.emodeldao.commodity.po.TCommodityType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 类描述:
 *
 * @author wzq
 * @date 2020/1/9 0009 15:29
 */
@Mapper
public interface TCommodityTypeDao {

    /**
     * 查询方法
     * @param t 查询数据
     * @param <T> 模板
     * @return 返回数据
     */
    <T>List<TCommodityType> find(Map<String,T> t);

    /**
     *
     * @param id id
     * @return t
     */
    TCommodityType findById(int id);

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
