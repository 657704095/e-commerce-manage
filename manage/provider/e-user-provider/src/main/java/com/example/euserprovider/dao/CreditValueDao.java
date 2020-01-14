package com.example.euserprovider.dao;

import com.example.emodeldao.user.po.TCreditValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 类描述:
 *  信用值表，
 * @author wzq
 * @date 2019/12/30 0030 16:48
 */
@Mapper
public interface CreditValueDao {

    /**
     * 查询通过信用键id和用户id
     * @param creditValue 信用信息
     * @param <T> 模板
     * @return 数据
     */
    <T>List<TCreditValue> findByCreditIdOrUserId(Map<String,T> creditValue);

    /**
     *
     * @param id id
     * @return t
     */
    TCreditValue findById(int id);

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
