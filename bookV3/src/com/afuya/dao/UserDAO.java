package com.afuya.dao;

import com.afuya.pojo.User;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/9 4:04 下午
 */
public interface UserDAO {

    /**
     * @param username
     * @return
     */
    public User queryUserByUsername(String username);

    /**
     * @param username
     * @param password
     * @return
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * @param user
     * @return
     */
    public int saveUser(User user);
}
