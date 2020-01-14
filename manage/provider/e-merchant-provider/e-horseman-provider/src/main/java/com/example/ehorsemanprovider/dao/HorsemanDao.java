package com.example.ehorsemanprovider.dao;

import com.example.emodeldao.merchant.po.THorseman;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 类描述:
 *
 * @author wzq
 * @date 2020/1/14 0014 13:59
 */
@Mapper
public interface HorsemanDao {

    /**
     *
     * @param horseman 骑手
     * @param <T> 模板
     * @return 数据
     */
    <T>List<THorseman> find(Map<String,T> horseman);

    /**
     *
     * @param id id
     * @return t
     */
    THorseman findById(int id);

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
