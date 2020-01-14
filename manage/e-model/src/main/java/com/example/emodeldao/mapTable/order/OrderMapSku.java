package com.example.emodeldao.mapTable.order;

import com.example.emodeldao.commodity.po.CommoditySku;
import com.example.emodeldao.merchant.po.TOrder;
import lombok.Data;

/**
 * 类描述:
 *一个订单下的多个商品
 * @author wzq
 * @date 2020/1/14 0014 18:09
 */
@Data
public class OrderMapSku {
    /**
     * 订单表
     */
    private TOrder orderId;

    /**
     * 商品表
     */
    private CommoditySku commoditySkuId;
}
