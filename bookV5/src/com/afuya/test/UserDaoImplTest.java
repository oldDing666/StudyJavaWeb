package com.afuya.test;

import com.afuya.dao.UserDao;
import com.afuya.dao.impl.UserDaoImpl;
import com.afuya.pojo.User;
import org.junit.Test;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/18 11:28 上午
 */
public class UserDaoImplTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("tom1234") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin", "12345") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null, "wzg168", "123456", "wzg168@qq.com")));
    }
}