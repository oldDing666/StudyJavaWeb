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
 * @date: 2021/10/9 5:33 下午
 */
public class RegistServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 获取值
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        if ("abcde".equalsIgnoreCase(code)) {
            if (userService.existsUsername(username)) {
                System.out.println("用户名[" + username + "]已存在!");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            } else {
                userService.registUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
            }
        } else {
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
        }
    }
}
