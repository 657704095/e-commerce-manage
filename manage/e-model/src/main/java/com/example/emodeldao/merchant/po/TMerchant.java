package com.example.emodeldao.merchant.po;

import com.example.emodeldao.annotation_validator.MyId;
import com.example.emodeldao.fatherPublic.po.Father;
import com.example.emodeldao.user.po.TAddressMinute;
import com.example.emodeldao.user.po.TCreditValue;
import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 类描述:
 *  商店
 * @Author: wzq
 * @Date: 2019/12/16 0016 16:49
 */
@Data
public class TMerchant extends Father {

    @Size(max = 10,message = "商家的名称最大不能大于10位")
    private String name;

    @Pattern(regexp = "^.{0,20}$",message = "年费")
    private double annualFee;

    @Pattern(regexp = "^.{0,20}$",message = "月费格式不对")
    private double monthlyFee;

    private TAddressMinute tAddressMinuteId;

    private TCreditValue tCreditValueId;
}
