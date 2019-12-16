package com.example.emodeldao.commodity.po;

import com.example.emodeldao.fatherPublic.po.Father2;
import lombok.Data;

/**
 * 类描述:
 *spu和spec的映射表，一个商品基本信息可以对应多个spec基本属性(描述一个商品，但不影响商品库存和价格)
 * @Author: wzq
 * @Date: 2019/12/16 0016 18:15
 */
@Data
public class CommoditySpuMapSpec extends Father2 {

    private CommoditySpu spuId;

    private CommoditySpecValue specValueId;
}
