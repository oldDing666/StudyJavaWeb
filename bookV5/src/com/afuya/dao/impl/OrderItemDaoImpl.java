package com.afuya.dao.impl;

import com.afuya.dao.OrderItemDao;
import com.afuya.pojo.OrderItem;

import java.util.List;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/21 9:01 下午
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item (name, count, price, total_price, order_id) values (?,?,?,?,?)";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        String sql = "select name, count, price, total_price totalPrice, order_id orderId from t_order_item where order_id = ?";
        return queryForList(OrderItem.class, sql, orderId);
    }
}
