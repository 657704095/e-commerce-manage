package com.example.emodeldao.commodity.po;

import com.example.emodeldao.fatherPublic.po.Father2AndDel;
import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 类描述:
 *商品表
 * img默认为一张图片，其他类型的图片，用spu来添加，中的spec来添加
 * @Author: wzq
 * @Date: 2019/12/16 0016 17:05
 */
@Data
public class CommoditySpu extends Father2AndDel {

    private TCommodityType tCommodityTypeId;

    private TCommodityBrand tCommodityBrandId;

    @Size(max = 20,message = "商品编号，不能大于20位")
    private String spuNo;

    @Size(max = 20,message = "商品名称，不能大于20位")
    private String spuName;

    @Pattern(regexp = "^.{0,20}$",message = "最低售价0-20位")
    private double lowPrice;

    @Size(max = 50,message = "图片最大长度不能大于50位")
    private String img;
}
