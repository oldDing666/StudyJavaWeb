package com.afuya.test;

import com.afuya.config.SpringConfig;
import com.afuya.pojo.Order;
import com.afuya.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/13 3:55 下午
 */
public class UserTest {


    @Test
    public void test1() {
        User user = new User();
        System.out.println(user);

//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        User user1 = context.getBean("user", User.class);
//        System.out.println(user1);

        ApplicationContext context1 = new ClassPathXmlApplicationContext("bean1.xml");
        User user2 = context1.getBean("user", User.class);
        System.out.println(user2);
    }

    @Test
    public void test2() {
        // 无参构造+set方法注入属性
        User user = new User();
        user.setName("afuya");
        System.out.println(user);

        // 有参构造注入属性
        User user1 = new User("afu");
        System.out.println(user1);

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        User user2 = context.getBean("user", User.class);
        System.out.println(user2);

        ApplicationContext context1 = new ClassPathXmlApplicationContext("bean1.xml");
        User user3 = context1.getBean("user", User.class);
        System.out.println(user3);
    }

    @Test
    public void test3() {
//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        Order order = context.getBean("order", Order.class);
//        System.out.println(order);
//
//        ApplicationContext context2 = new AnnotationConfigApplicationContext(SpringConfig.class);
//        Order order2 = context2.getBean("order", Order.class);
//        System.out.println(order2);
//        System.out.println(order == order2);
//        System.out.println(order.equals(order2));

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        User user = context.getBean("user", User.class);
        System.out.println(user);

        User user2 = context.getBean("user", User.class);
        System.out.println(user2);
        System.out.println(user == user2);
        System.out.println(user.equals(user2));


//        ApplicationContext context3 = new ClassPathXmlApplicationContext("bean1.xml");
//        User user3 = context3.getBean("user", User.class);
//        System.out.println(user3);
//
//        ApplicationContext context4 = new ClassPathXmlApplicationContext("bean1.xml");
//        User user4 = context4.getBean("user", User.class);
//        System.out.println(user4);
//        System.out.println(user3 == user4);
//        System.out.println(user3.equals(user4));


//        ApplicationContext context5 = new ClassPathXmlApplicationContext("bean1.xml");
//        Order order = context5.getBean("order", Order.class);
//        System.out.println(order);
//
//        ApplicationContext context6 = new ClassPathXmlApplicationContext("bean1.xml");
//        Order order2 = context6.getBean("order", Order.class);
//        System.out.println(order2);
//        System.out.println(order == order2);
//        System.out.println(order.equals(order2));

//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        Order order3 = context.getBean("order", Order.class);
//        System.out.println(order3);
//
//        Order order4 = context.getBean("order", Order.class);
//        System.out.println(order4);
//        System.out.println(order3 == order4);
//        System.out.println(order3.equals(order4));
    }

}