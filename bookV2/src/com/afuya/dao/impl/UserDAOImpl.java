package com.afuya.dao.impl;

import com.afuya.dao.UserDAO;
import com.afuya.pojo.User;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/9 4:04 下午
 */
public class UserDAOImpl extends BaseDAO implements UserDAO {


    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from t_user where username=?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username=? and password=?";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username, password, email) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
