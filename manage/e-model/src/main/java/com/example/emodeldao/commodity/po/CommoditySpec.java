package com.example.emodeldao.commodity.po;

import com.example.emodeldao.fatherPublic.po.Father2;
import com.example.emodeldao.fatherPublic.po.Father2AndDel;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * 类描述:
 *然后是SPU,sku规格相关的表
 * 规格表：
 * @Author: wzq
 * @Date: 2019/12/16 0016 17:41
 */
@Data
public class CommoditySpec extends Father2AndDel {

    @Size(max = 20,message = "spu,或sku编号位数超过20位。")
    private String specNo;

    @Size(max = 20,message = "规格名称不能大于20位")
    private String specName;

}
