package com.afuya.dao;

import com.afuya.pojo.User;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/18 11:13 上午
 */
public interface UserDao {
    /**
     * 注册查看用户名是否存在
     *
     * @param name
     * @return
     */
    public User queryUserByUsername(String name);

    /**
     * 登录时，验证账号密码
     *
     * @param name
     * @param password
     * @return
     */
    public User queryUserByUsernameAndPassword(String name, String password);

    /**
     * 注册成功，保存账号密码
     *
     * @param user
     * @return
     */
    public int saveUser(User user);
}
