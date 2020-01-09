package com.example.emodeldao.fatherPublic.po;

import com.example.emodeldao.annotation_validator.MyId;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * 公用类
 * @author Administrator
 */
@Data
public class Father {

    @MyId
    private Integer id;

    @Size(max = 20,message = "创建时间最大长度不能大于20位")
    private String creationTime;

    @Size(max = 20,message = "修改时间的最大长度不能大于20位")
    private String modifyTime;

    @Size(max = 11,message = "修改人的id，挂admin的id")
    private String modifyId;
}
