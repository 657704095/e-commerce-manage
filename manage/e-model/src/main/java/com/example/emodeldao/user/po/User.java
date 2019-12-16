package com.example.emodeldao.user.po;

import com.example.emodeldao.annotation_validator.MyId;
import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class User {
    @MyId
    private Integer id;

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

    @Size(max = 11,message = "用户信用表id的最大长度不能大于11位")
    private Integer tAddressMinuteId;

    @Size(max = 11,message = "信用值表的id，最大长度不能大于11位")
    private Integer tCreditKeyId;

    @Size(max = 20,message = "创建时间最大长度不能大于20位")
    private String creationTime;

    @Size(max = 20,message = "修改时间的最大长度不能大于20位")
    private String modifyTime;

    @Size(max = 11,message = "修改人的id，挂admin的id")
    private String modifyId;

    @Size(max = 2,message = "类型状态最大位数不能大于2位，1为店家，2为买家")
    private Integer type;
}
