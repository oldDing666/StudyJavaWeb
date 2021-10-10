package com.afuya.service;

import com.afuya.dao.UserDAO;
import com.afuya.dao.impl.UserDAOImpl;
import com.afuya.pojo.User;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/9 5:21 下午
 */
public class UserServiceImpl implements UserService {
    UserDAO userDAO = new UserDAOImpl();

    @Override
    public void registUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDAO.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDAO.queryUserByUsername(username) != null) {
            return true;
        }
        return false;
    }
}
