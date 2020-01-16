package com.example.emodeldao.commodity.po;

import com.example.emodeldao.fatherPublic.po.Father2;
import com.example.emodeldao.fatherPublic.po.Father2AndDel;
import lombok.Data;

/**
 * 类描述:
 *SKU规格值表
 * @Author: wzq
 * @Date: 2019/12/16 0016 18:19
 */
@Data
public class CommoditySkuMapSpecValue extends Father2AndDel {

    private CommoditySku skuId;

    private CommoditySpecValue specValueId;
}
