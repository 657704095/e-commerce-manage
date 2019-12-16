package com.example.eadminprovider.dao;

import com.example.emodeldao.admin.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao {

    Admin findByIdOrAdminName(Admin admin);

    Admin findById(Admin admin);

    int insert(Admin admin);

    int modify(Admin admin);
}
