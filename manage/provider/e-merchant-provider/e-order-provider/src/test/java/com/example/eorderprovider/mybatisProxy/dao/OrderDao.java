package com.example.eorderprovider.mybatisProxy.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * 类描述:
 *
 * @author wzq
 * @date 2020/1/14 0014 16:09
 */
public interface OrderDao {

    @Insert(value = "")
    int add(String str);

    @Update(value = "")
    int update(String str);

}
