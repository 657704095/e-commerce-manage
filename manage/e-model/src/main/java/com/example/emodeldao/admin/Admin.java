package com.example.emodeldao.admin;

import com.example.emodeldao.annotation_validator.MyId;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * admin表，系统管理员
 * @author Administrator
 */
@Data
public class Admin {

    //@Size(max = 11,message = "id不能大于11为")
    @MyId(length = 11,message = "id不能大于11位")
    private Integer id;

    /**
     * 唯一键
     */
    @Size(max = 9,message = "管理员账号长度不能大于9")
    private String adminName;

    @Size(max = 11,message = "管理员密码不能大于11位")
    private String adminPwd;

    @Size(max = 20,message = "管理员创建时间不能大于20位")
    private String creationTime;

    @Size(max = 20,message = "管理员修改时间不能大于20位")
    private String updataTime;

}
