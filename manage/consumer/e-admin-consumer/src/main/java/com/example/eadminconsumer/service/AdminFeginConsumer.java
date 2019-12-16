package com.example.eadminconsumer.service;

import com.example.emodeldao.admin.Admin;

/**
 *  业务接口
 * @author wzq
 */
public interface AdminFeginConsumer {

    public Admin findByIdOrAdminName(Admin admin);

    public Admin fingById(Admin admin);

    public int insert(Admin admin);

    public int upmodify(Admin admin);
}
