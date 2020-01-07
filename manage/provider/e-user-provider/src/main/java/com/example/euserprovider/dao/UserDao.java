package com.example.euserprovider.dao;

import com.example.emodeldao.user.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 类描述:
 *  用户类的基本操作
 * @author wzq
 * @date 2020/1/2 0002 9:56
 */
@Mapper
public interface UserDao {
    /**
     * 通过id查询,提供mybaits延迟加载使用
     * @param id id
     * @return 用户
     */
    User findById(int id);


    /**
     * 插入数据
     * @param user 数据
     * @param <T> 模板
     * @return 条数
     */
    <T>int insert(Map<String,T> user);

    /**
     * 修改数据
     * @param user 数据
     * @param <T> 模板
     * @return 条数
     */
    <T>int update(Map<String,T> user);

    /**
     * 删除数据
     * @param user 数据
     * @param <T> 模板
     * @return 条数
     */
    <T>int del(Map<String,T> user);
}
