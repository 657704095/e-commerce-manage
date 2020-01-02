package com.example.euserprovider.dao;

import com.example.emodeldao.user.po.User;

/**
 * 类描述:
 *  用户类的基本操作
 * @author wzq
 * @date 2020/1/2 0002 9:56
 */
public interface UserDao {
    /**
     * 通过id查询
     * @param id id
     * @return 用户
     */
    User findById(int id);
}
