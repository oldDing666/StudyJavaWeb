package com.afuya.service;

import com.afuya.pojo.Cart;
import com.afuya.pojo.Order;
import com.afuya.pojo.OrderItem;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/21 9:07 下午
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param cart
     * @param usrId
     * @return
     */
    public String createOrder(Cart cart, Integer usrId);

    /**
     * 查询所有的订单
     *
     * @return
     */
    public List<Order> showAllOrders();

    /**
     * 点击发货
     *
     * @param orderId
     * @return
     */
    public int sendOrder(String orderId);

    /**
     * 查看订单详情
     *
     * @param orderId
     * @return
     */
    public List<OrderItem> showOrderDetail(String orderId);

    /**
     * 查看我的订单
     *
     * @param userId
     * @return
     */
    public List<Order> showMyOrders(Integer userId);

    /**
     * 点击收货
     *
     * @param orderId
     * @return
     */
    public int receiveOrder(String orderId);
}
