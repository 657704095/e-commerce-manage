package com.example.emodeldao.mapTable.merchant;

import com.example.emodeldao.commodity.po.CommoditySku;
import com.example.emodeldao.merchant.po.TMerchant;
import lombok.Data;

/**
 * 类描述:
 *商铺和商品的映射关系
 *
 * 一个商铺可以有多个商品信息
 * @Author: wzq
 * @Date: 2019/12/16 0016 18:30
 */
@Data
public class MerchantMapCommodity {

    private TMerchant merchantId;

    private CommoditySku commodityId;
}
