package com.example.emodeldao.mapTable.merchant;

import com.example.emodeldao.merchant.po.TMerchant;
import com.example.emodeldao.user.po.User;
import lombok.Data;

/**
 * 类描述:
 *店铺和商家的映射关系
 * @Author: wzq
 * @Date: 2019/12/16 0016 18:37
 */
@Data
public class MerchantMapUser {

    private TMerchant merchantId;

    private User userId;
}
