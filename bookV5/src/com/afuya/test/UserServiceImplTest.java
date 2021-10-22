package com.afuya.test;

import com.afuya.pojo.User;
import com.afuya.service.UserService;
import com.afuya.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/18 3:20 下午
 */
public class UserServiceImplTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null, "bbj168", "666666", "bbj168@qq.com"));
        userService.registUser(new User(null, "abc168", "666666", "abc168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "wzg168", "123456", null)));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("wzg168")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }
}