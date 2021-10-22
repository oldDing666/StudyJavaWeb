package com.afuya.web;

import com.afuya.pojo.*;
import com.afuya.service.BookService;
import com.afuya.service.OrderService;
import com.afuya.service.impl.BookServiceImpl;
import com.afuya.service.impl.OrderServiceImpl;
import com.afuya.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/21 8:46 下午
 */
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
//            resp.sendRedirect("pages/user/login.jsp");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        String orderId = orderService.createOrder(cart, user.getId());
        req.getSession().setAttribute("orderId", orderId);
        // resp.sendRedirect("pages/cart/checkout.jsp");
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.showAllOrders();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);
    }

    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.sendOrder(orderId);
        resp.sendRedirect(req.getContextPath() + "/orderServlet?action=showAllOrders");
    }

    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        System.out.println(orderId);
        List<OrderItem> orderItems = orderService.showOrderDetail(orderId);
        System.out.println(orderItems);
        req.setAttribute("orderItems", orderItems);
        req.getRequestDispatcher("/pages/order/order_detail.jsp").forward(req, resp);
    }

    protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        List<Order> orders = orderService.showMyOrders(user.getId());
        System.out.println(orders);
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
    }

    protected void receiveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.receiveOrder(orderId);
        resp.sendRedirect(req.getContextPath() + "/orderServlet?action=showMyOrders");
    }
}
