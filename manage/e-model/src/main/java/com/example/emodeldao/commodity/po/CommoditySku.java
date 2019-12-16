package com.example.emodeldao.commodity.po;

import com.example.emodeldao.annotation_validator.MyId;
import com.example.emodeldao.fatherPublic.po.Father2;
import com.example.emodeldao.merchant.po.TMerchant;
import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 类描述:
 *接下来是SKU相关的表：
 * SKU表：
 * 最小库存单元key
 * 因为有商品唯一编号，这个表示为厂库中某一个唯一的产品，自然有其对应的商家(某一类，不是某一个)
 * @Author: wzq
 * @Date: 2019/12/16 0016 17:14
 */
@Data
public class CommoditySku extends Father2 {

    @MyId(length = 20,message = "sku编号,唯一,商品编号不能大于20位")
    private Integer skuNo;

    @Size(max = 20,message = "sku的商品名称不能大于20位")
    private String skuName;

    @Pattern(regexp = "^.{0,20}$",message = "售价0-20位")
    private double price;

    @Pattern(regexp = "^.{0,20}$",message = "库存在0-20位")
    private double stock;

    @Size(max = 20,message = "库存单位最大位数不能大于20位")
    private String stockUnit;

    private CommoditySpu spuId;

    private TMerchant merchantId;

    @MyId(length = 2,message = "1上架，2下架")
    private Integer state;

    @MyId(length = 2,message = "0删除，1存在")
    private Integer del;
}
