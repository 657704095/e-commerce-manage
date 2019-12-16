package com.example.eadminprovider.provider;


import com.example.eadminprovider.dao.AdminDao;
import com.example.eadminprovider.tool.SetA_UniqueAccount;
import com.example.emodeldao.ValidatorUtils.ValidatorUtils;
import com.example.emodeldao.admin.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * admin的服务提工者
 * @author wzq
 * 2019/12/10
 */
@RestController
@RequestMapping("/AdminDaoProvider")
@Slf4j
public class AdminDaoProvider {

    /**
     * 调用工具类
     */
    private SetA_UniqueAccount setAuniqueAccount = new SetA_UniqueAccount();

    @Resource
    private AdminDao adminDao;


    /**
     * 查询方法
     * @param admin
     * @return
     */
    @RequestMapping("/findByIdOrAdminName")
    public Admin findByIdOrAdminName(@RequestBody Admin admin){
        log.info("查询服务提供者fegin层中接受的对象为:{}",admin);
        /*MyIdValidator.setAdmin(admin);*/
        ValidatorUtils.validateEntity(admin);
        return adminDao.findByIdOrAdminName(admin);
    }

    /**
     * 通过id创建一个事件
     * @param admin
     * @return
     */
    @RequestMapping("/findById")
    public Admin findById(@RequestBody Admin admin){
        log.info("id查询服务提供者fegin层中接受的对象为:{}",admin);
        ValidatorUtils.validateEntity(admin);
        return adminDao.findById(admin);
    }

    /**
     * 插入一条数据
     * @param admin
     * @return
     */
    @RequestMapping("/insert")
    public int insert(@RequestBody Admin admin){
        log.info("插入服务提供者fegin层中接受的对象为:{}",admin);
        ValidatorUtils.validateEntity(admin);
        return adminDao.insert(admin);
    }

    /**
     * 修改方法
     * @param admin
     * @return
     */
    @RequestMapping("/upmodify")
    public int upmodify(@RequestBody Admin admin){
        log.info("修改服务提供者fegin层中接受的对象为:{}",admin);
        boolean flag = setAuniqueAccount.uniquenessAdmin(admin);
        ValidatorUtils.validateEntity(admin);

        int rest = 0;

        if(flag ==true){
            log.info("修改的对象为skylong，不允许修改，删除，作为最为最高级管理原理使用。");
        }else{
            log.info("修改的对象不为skylong，系统信息修改。");
            rest = adminDao.modify(admin);
        }

        return  rest;
    }

}
