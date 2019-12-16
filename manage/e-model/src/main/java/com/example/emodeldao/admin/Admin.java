package com.example.emodeldao.admin;

import com.example.emodeldao.annotation_validator.MyId;

import javax.validation.constraints.Size;

public class Admin {

    //@Size(max = 11,message = "id不能大于11为")
    @MyId(length = 11,message = "id不能大于11位")
    private Integer id;

    @Size(max = 9,message = "管理员账号长度不能大于9")
    private String adminName;

    @Size(max = 11,message = "管理员密码不能大于11位")
    private String adminPwd;

    @Size(max = 20,message = "管理员创建时间不能大于20位")
    private String creationTime;

    @Size(max = 20,message = "管理员修改时间不能大于20位")
    private String updataTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getUpdataTime() {
        return updataTime;
    }

    public void setUpdataTime(String updataTime) {
        this.updataTime = updataTime;
    }
}
