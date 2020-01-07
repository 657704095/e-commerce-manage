package com.example.emodeldao.user.po;

import com.example.emodeldao.annotation_validator.MyId;
import com.example.emodeldao.fatherPublic.po.FatherAndDel;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * 类描述:
 *  t_credit_value信用值表
 * @Author: wzq
 * @Date: 2019/12/16 0016 16:21
 */
@Data
public class TCreditValue extends FatherAndDel {

    private TCreditKey tCreditId;

    @Size(max = 20,message = "信用的值最大不能大于20位")
    private String value;

    private User userId;

}
