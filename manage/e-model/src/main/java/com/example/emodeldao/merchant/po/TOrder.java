package com.example.emodeldao.merchant.po;

import com.example.emodeldao.annotation_validator.MyId;
import com.example.emodeldao.commodity.po.CommoditySku;
import com.example.emodeldao.commodity.po.CommoditySpu;
import com.example.emodeldao.fatherPublic.po.Father;
import com.example.emodeldao.user.po.User;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * 类描述:
 *  订单表
 * @Author: wzq
 * @Date: 2019/12/16 0016 16:25
 */
@Data
public class TOrder extends Father {

    @Size(max = 20,message = "订单号最长不能大于20位")
    private String order_number;

    private TMerchant tMerchantId;

    private User tUserId;

    private CommoditySku tCommodityId;

    @MyId(message = "商品数量不能大于11位")
    private Integer amount;

    @MyId(length = 2,message = "1下单，2退单")
    private Integer state;

    @MyId(length = 2,message = "1admin,2user")
    private Integer modifyIdType;
}
