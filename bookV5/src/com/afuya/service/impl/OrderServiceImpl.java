package com.afuya.service.impl;

import com.afuya.dao.BookDao;
import com.afuya.dao.OrderDao;
import com.afuya.dao.OrderItemDao;
import com.afuya.dao.impl.BookDaoImpl;
import com.afuya.dao.impl.OrderDaoImpl;
import com.afuya.dao.impl.OrderItemDaoImpl;
import com.afuya.pojo.*;
import com.afuya.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/21 9:09 下午
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer usrId) {
        String orderId = System.currentTimeMillis() + "" + usrId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, usrId);
        orderDao.saveOrder(order);

        Map<Integer, CartItem> items = cart.getItems();
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);

            Book book = bookDao.queryBookById(cartItem.getId());
            book.setStock(book.getStock() - cartItem.getCount());
            book.setSales(book.getSales() + cartItem.getCount());
            bookDao.updateBook(book);
        }
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDao.queryOrders();
    }

    @Override
    public int sendOrder(String orderId) {
        return orderDao.changeOrderStatus(orderId, 1);
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        return orderItemDao.queryOrderItemsByOrderId(orderId);
    }

    @Override
    public List<Order> showMyOrders(Integer userId) {
        return orderDao.queryOrdersByUserId(userId);
    }

    @Override
    public int receiveOrder(String orderId) {
        return orderDao.changeOrderStatus(orderId, 2);
    }
}
