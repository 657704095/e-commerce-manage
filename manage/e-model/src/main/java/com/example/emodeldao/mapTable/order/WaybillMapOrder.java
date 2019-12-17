package com.example.emodeldao.mapTable.order;

import com.example.emodeldao.merchant.po.TOrder;
import com.example.emodeldao.merchant.po.TWaybill;
import lombok.Data;

/**
 * 类描述:
 *一个运单对应多个订单表
 *
 * 这里可能会出现空运单的情况
 * @Author: wzq
 * @Date: 2019/12/17 0017 9:24
 */
@Data
public class WaybillMapOrder {

    private TWaybill waybillId;

    private TOrder orderId;

}
