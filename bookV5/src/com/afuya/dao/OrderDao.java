package com.afuya.dao;

import com.afuya.pojo.Order;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/21 8:53 下午
 */
public interface OrderDao {
    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    public int saveOrder(Order order);

    /**
     * 查询所有订单
     *
     * @return
     */
    public List<Order> queryOrders();


    /**
     * 改变订单状态：发货/签收
     *
     * @param orderId
     * @param status
     * @return
     */
    public int changeOrderStatus(String orderId, Integer status);

    /**
     * 根据用户ID查看「我的订单」功能
     *
     * @param userId
     * @return
     */
    public List<Order> queryOrdersByUserId(Integer userId);
}
