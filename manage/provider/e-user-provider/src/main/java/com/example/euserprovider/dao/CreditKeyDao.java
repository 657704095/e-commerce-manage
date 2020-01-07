package com.example.euserprovider.dao;

import com.example.emodeldao.user.po.TCreditKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 类描述:
 *  信用键表
 * @author wzq
 * @date 2019/12/30 0030 16:48
 */
@Mapper
public interface CreditKeyDao {

    /**
     * 查询
     * @param id 条件
     * @return 返回数据
     */
    TCreditKey findById(int id);

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
