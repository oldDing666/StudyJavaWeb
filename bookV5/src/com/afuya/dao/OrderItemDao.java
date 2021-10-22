package com.afuya.dao;

import com.afuya.pojo.OrderItem;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/21 8:54 下午
 */
public interface OrderItemDao {
    /**
     * 创建订单
     *
     * @param orderItem
     * @return
     */
    public int saveOrderItem(OrderItem orderItem);

    /**
     * 根据订单编号，查找订单详情
     *
     * @param orderId
     * @return
     */
    public List<OrderItem> queryOrderItemsByOrderId(String orderId);
}
