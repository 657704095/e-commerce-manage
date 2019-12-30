package com.example.eadminprovider.provider;


import com.example.eadminprovider.dao.AdminDao;
import com.example.eadminprovider.tool.SetA_UniqueAccount;
import com.example.emodeldao.ValidatorUtils.ValidatorUtils;
import com.example.emodeldao.admin.Admin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * admin的服务提工者
 * @author wzq
 * 2019/12/10
 */
@Api(value="系统管理员controller",tags={"系统管理员操作接口"})
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
     * @param admin 管理员
     * @return 管理员
     */
    @ApiOperation(value = "查询管理员通过id或者管理员名" ,notes="查询管理员通过id或者管理员名")
    @PostMapping("/findByIdOrAdminName")
    public Admin findByIdOrAdminName(@RequestBody Admin admin){
        log.info("查询服务提供者fegin层中接受的对象为:{}",admin);
        /*MyIdValidator.setAdmin(admin);*/
        ValidatorUtils.validateEntity(admin);
        return adminDao.findByIdOrAdminName(admin);
    }

    /**
     * 通过id创建一个事件
     * @param admin 管理员
     * @return 管理员
     */
    @ApiOperation(value = "查询管理通过id" ,notes="查询管理通过id")
    @PostMapping("/findById")
    public Admin findById(@RequestBody Admin admin){
        log.info("id查询服务提供者fegin层中接受的对象为:{}",admin);
        ValidatorUtils.validateEntity(admin);
        return adminDao.findById(admin);
    }

    /**
     * 插入一条数据
     * @param admin 管理员
     * @return 个数
     */
    @ApiOperation(value = "插入管理员" ,notes="插入管理员")
    @PostMapping("/insert")
    public int insert(@RequestBody Admin admin){
        log.info("插入服务提供者fegin层中接受的对象为:{}",admin);
        ValidatorUtils.validateEntity(admin);
        return adminDao.insert(admin);
    }

    /**
     * 修改方法
     * @param admin 管理员
     * @return 个数
     */
    @ApiOperation(value = "修改管理员" ,notes="修改管理员")
    @PostMapping("/update")
    public int update(@RequestBody Admin admin){
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
