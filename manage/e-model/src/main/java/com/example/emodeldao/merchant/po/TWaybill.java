package com.example.emodeldao.merchant.po;

import com.example.emodeldao.fatherPublic.po.Father;
import com.example.emodeldao.fatherPublic.po.FatherAndDel;
import com.example.emodeldao.user.po.TAddressMinute;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * 类描述:
 *  运单
 * @Author: wzq
 * @Date: 2019/12/16 0016 16:35
 */
@Data
public class TWaybill extends FatherAndDel {

    @Size(max = 20,message = "运单号最大不能大于20位")
    private String waybillNumber;

    private THorseman tHorsemanId;

    private TAddressMinute tAddressMinuteId;
}
