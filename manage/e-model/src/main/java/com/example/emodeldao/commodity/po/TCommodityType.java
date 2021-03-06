package com.example.emodeldao.commodity.po;

import com.example.emodeldao.fatherPublic.po.FatherAndDel;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * 类描述:
 *  分类
 * @Author: wzq
 * @Date: 2019/12/16 0016 18:09
 */
@Data
public class TCommodityType extends FatherAndDel {

    @Size(max = 20,message = "分类名不能大于20位")
    private String type;

    private TCommodityType LV;

}
