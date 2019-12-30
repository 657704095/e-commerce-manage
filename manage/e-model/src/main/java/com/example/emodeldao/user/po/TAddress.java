package com.example.emodeldao.user.po;

import com.example.emodeldao.fatherPublic.po.Father;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * 类描述t_address表，地址表
 * @author Administrator
 */
@Data
public class TAddress extends Father {

    @Size(max = 10,message = "省份字段不能大于10位")
    private String province;

    @Size(max = 10,message = "县城字段不能大于10位")
    private String city;

    @Size(max = 30,message = "乡镇或者街道字段不能大于30位")
    private String districtOrTown;

    @Size(max = 50,message = "唯一编码不能大于50位")
    private String code;

}
