package com.example.eadminconsumer.Fegin;

import com.example.emodeldao.admin.Admin;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * feign远程调用注册中心的contrller
 * @author wzq
 */
@FeignClient(value = "e-admin-provider")
public interface AdminDaoFegin {

    @RequestMapping("/AdminDaoProvider/findByIdOrAdminName")
    public Admin findByIdOrAdminName(@RequestBody Admin admin);

    @RequestMapping("/AdminDaoProvider/findById")
    public Admin fingById(@RequestBody Admin admin);

    @RequestMapping("/AdminDaoProvider/insert")
    public int insert(Admin admin);

    @RequestMapping("/AdminDaoProvider/upmodify")
    public int upmodify(Admin admin);
}
