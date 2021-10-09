package com.afuya.web;

import com.afuya.pojo.User;
import com.afuya.service.UserService;
import com.afuya.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/9 8:05 下午
 */
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(new User(null, username, password, null));
        if (user != null) {
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req, resp);
        } else {
            System.out.println("账号或密码错误");
            req.getRequestDispatcher("/pages/user/login.html").forward(req, resp);
        }
    }
}
