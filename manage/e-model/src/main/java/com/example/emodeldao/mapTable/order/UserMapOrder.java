package com.example.emodeldao.mapTable.order;

import com.example.emodeldao.merchant.po.TOrder;
import com.example.emodeldao.user.po.User;
import lombok.Data;

/**
 * 类描述:
 *用户和订单的应关系
 *
 * 一个用户可以有多个订单
 * @Author: wzq
 * @Date: 2019/12/17 0017 9:22
 */
@Data
public class UserMapOrder {

    private User userId;

    private TOrder orderId;
}
