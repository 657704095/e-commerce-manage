package com.example.emodeldao.fatherPublic.po;

import com.example.emodeldao.annotation_validator.MyId;
import lombok.Data;

/**
 * 类描述:
 *
 * @author wzq
 * @date 2020/1/2 0002 11:15
 */
@Data
public class FatherAndDel extends Father{

    @MyId(length = 1)
    private Integer del;
}
