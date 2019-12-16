package com.example.eadminconsumer.contrller;

import com.example.emodeldao.admin.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.eadminconsumer.service.AdminFeginConsumer;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 *  为前端的访问提供接口
 * @author wzq
 */
@RestController
@RequestMapping("/Admin")
@Slf4j
public class AdminFeginImplContrller {

    @Autowired
    private AdminFeginConsumer AdminFeginConsumer;

    @RequestMapping("/findByIdOrAdminName")
    public Admin findByIdOrAdminName(HttpServletRequest request){
        //封装数据begin
        String adminName = request.getParameter("adminName");
        String adminId_str = request.getParameter("adminId");

        int adminId = 0;

        if(adminId_str!=null&&!adminId_str.equals("")){
            adminId = new Integer(adminId_str);
        }else{
            log.info("没有上传admin的id，但默认id为必填项。");
        }

        Admin admin = new Admin();
        admin.setAdminName(adminName);
        admin.setId(adminId);
        //封装数据end

        Admin res = AdminFeginConsumer.findByIdOrAdminName(admin);

        if(res!=null){
            log.info("contrller执行成功，返回数据为：{}",res);
        }else{
            log.error("数据没有返回，可能访问fegin失败。");
        }

        return res;
    }

    @RequestMapping("/findById")
    public Admin findById(HttpServletRequest request){
        //封装数据begin
        String adminId_str = request.getParameter("adminId");
        int adminId = 0;
        if(adminId_str!=null&&!adminId_str.equals("")){
            log.info("没有上传admin的id，但默认id为必填项。");
            adminId = new Integer(adminId_str);
        }

        Admin admin = new Admin();
        admin.setId(adminId);
        //封装数据end

        Admin res = AdminFeginConsumer.fingById(admin);

        if(res!=null){
            log.info("contrller执行成功，返回数据为：{}",res);
        }else{
            log.error("数据没有返回，可能访问fegin失败。");
        }

        return res;
    }

    @RequestMapping("/insert")
    public int insert(@RequestBody Admin admin){
        int i = AdminFeginConsumer.insert(admin);

        if(i>=1){
            log.info("插入contrller执行成功，返回数据为：{}",i);
        }else{
            log.error("插入数据没有返回，可能访问fegin失败。");
        }

        return i;
    }

    @RequestMapping("/modify")
    public int modify(@RequestBody Admin admin){
        int i = AdminFeginConsumer.upmodify(admin);

        if(i>=1){
            log.info("插入contrller执行成功，返回数据为：{}",i);
        }else{
            log.error("插入数据没有返回，可能访问fegin失败。");
        }

        return i;
    }
}
