package com.afuya.service;

import com.afuya.pojo.User;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/9 5:19 下午
 */
public interface UserService {

    public void registUser(User user);

    public User login(User user);

    public boolean existsUsername(String username);
}
