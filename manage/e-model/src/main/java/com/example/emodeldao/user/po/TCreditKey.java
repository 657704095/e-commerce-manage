package com.example.emodeldao.user.po;

import com.example.emodeldao.fatherPublic.po.Father;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * 类描述:
 *  t_credit_key信用键表
 * @Author: wzq
 * @Date: 2019/12/16 0016 16:18
 */
@Data
public class TCreditKey extends Father {

    @Size(max = 20,message = "最大键长不能大于20位")
    private String key;
}
