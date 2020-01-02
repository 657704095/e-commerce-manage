package com.example.emodeldao.user.po;

import com.example.emodeldao.annotation_validator.MyId;
import com.example.emodeldao.fatherPublic.po.FatherAndDel;
import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * user表，用户表
 * @author Administrator
 */
@Data
public class User extends FatherAndDel {
    /**
     * 唯一索引，user账号
     */
    @Size(max = 10,message = "用户账号不能大于10位。")
    private String userName;

    @Size(max = 10,message = "用户昵称不能大于10位")
    private String userNickName;

    @Size(max = 10,message = "用户密码不能大于10位")
    private String userPwd;

    @Size(max = 20,message = "密保问题不能大于20位")
    private String userQuestionEncrypted;

    @Size(max = 20,message = "密保答案不能大于20位")
    private String userQuestionEncryptedAnswer;

    @Size(max = 18,message = "用户手机最长不能大于18位")
    private String tel;

    @Size(max = 20,message = "用户邮箱最大长度不能大于20")
    private String email;

    @Size(max = 30,message = "用户省份证长度不能大于30位")
    @Pattern(regexp = "^[A-Za-z0-9]+$",message = "只能如输入数字和字母")
    private String IDCard;

    @Size(max = 10,message = "用户姓名最大长度不能大于10位")
    private String realName;
    /**
     * 这个字段已废弃
     */
    private TAddressMinute tAddressMinuteId;

    private TCreditValue tCreditValueId;

    @MyId(length = 2,message = "类型状态最大位数不能大于2位，1为店家，2为买家")
    private Integer type;
}
