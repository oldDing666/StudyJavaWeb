package com.afuya.service.impl;

import com.afuya.dao.UserDao;
import com.afuya.dao.impl.UserDaoImpl;
import com.afuya.pojo.User;
import com.afuya.service.UserService;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/18 3:11 下午
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            return false;
        }
        return true;
    }
}
