package com.example.emodeldao.mapTable.merchant;

import com.example.emodeldao.merchant.po.TMerchant;
import com.example.emodeldao.merchant.po.TOrder;
import lombok.Data;

/**
 * 类描述:
 *商家对应多个订单表
 * @Author: wzq
 * @Date: 2019/12/16 0016 18:35
 */
@Data
public class MerchantMapOrder {

    private TMerchant merchantId;

    private TOrder orderId;
}
