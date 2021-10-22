package com.afuya.service;

import com.afuya.pojo.User;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/18 3:11 下午
 */
public interface UserService {
    /**
     * 注册，不返回值
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录。返回一个用户对象
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 查看用户名是否存在
     * @param username
     * @return
     */
    public boolean existsUsername(String username);
}
