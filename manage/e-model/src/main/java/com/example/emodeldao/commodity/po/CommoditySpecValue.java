package com.example.emodeldao.commodity.po;

import com.example.emodeldao.fatherPublic.po.Father2;
import com.example.emodeldao.fatherPublic.po.Father2AndDel;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * 类描述:
 *
 * @Author: wzq
 * @Date: 2019/12/16 0016 17:45
 */
@Data
public class CommoditySpecValue extends Father2AndDel {

    private CommoditySpec specId;

    @Size(max = 20,message = "属性规格值不能大于20位")
    private String specValue;

}
