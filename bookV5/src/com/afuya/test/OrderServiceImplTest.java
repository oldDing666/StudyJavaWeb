package com.afuya.test;

import com.afuya.pojo.Order;
import com.afuya.service.OrderService;
import com.afuya.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/22 10:51 上午
 */
public class OrderServiceImplTest {
    OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
    }

    @Test
    public void showAllOrders() {
        List<Order> orders = orderService.showAllOrders();
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}