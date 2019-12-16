package com.example.emodeldao.commodity.po;

import com.example.emodeldao.fatherPublic.po.Father;

import javax.validation.constraints.Size;

/**
 * 类描述:
 *  品牌名
 * @Author: wzq
 * @Date: 2019/12/16 0016 18:13
 */
public class TCommodityBrand extends Father {

    @Size(max = 20,message = "名牌名不能大于20位")
    private String name;
}
