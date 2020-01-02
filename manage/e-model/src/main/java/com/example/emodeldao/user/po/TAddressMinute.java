package com.example.emodeldao.user.po;

import com.example.emodeldao.fatherPublic.po.Father;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * 类描述:
 * t_address_minute（地址详情表）
 * @Author: wzq
 * @Date: 2019/12/16 0016 16:07
 */
@Data
public class TAddressMinute extends Father {
    /**
     * 地址，省，市，镇表
     */
    private TAddress tAddressId;

    @Size(max = 30,message = "地址最大位数不能大于30位")
    private String concretenessAddress;

    /**
     * 用户表
     */
    private User userId;

    @Size(max = 2,message = "1为admin，2为user")
    private String modifyIdType;
}
