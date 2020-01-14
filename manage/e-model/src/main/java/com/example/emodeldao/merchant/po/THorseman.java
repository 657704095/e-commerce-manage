package com.example.emodeldao.merchant.po;

import com.example.emodeldao.fatherPublic.po.Father;
import com.example.emodeldao.fatherPublic.po.FatherAndDel;
import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 类描述:
 *
 * @Author: wzq
 * @Date: 2019/12/16 0016 16:39
 */
@Data
public class THorseman extends FatherAndDel {

    @Size(max = 10,message = "骑手姓名不能大于10位")
    private String name;

    @Size(max = 18,message = "电话不能大于18位")
    @Pattern(regexp = "^[0-9]*$",message = "只能输入数字")
    private String tel;

    @Size(max = 30,message = "用户省份证长度不能大于30位")
    @Pattern(regexp = "^[A-Za-z0-9]+$",message = "只能如输入数字和字母")
    private String IDCard;

    @Size(max = 10,message = "安全行为数不能大于10位")
    private String safeBehaviorNumber;
}
