package com.afuya.web;

import com.afuya.pojo.User;
import com.afuya.service.UserService;
import com.afuya.service.UserServiceImpl;
import com.afuya.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/10 9:19 下午
 */
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.login(WebUtils.copyParamToBean(req.getParameterMap(), new User()));
        if (user != null) {
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        } else {
            System.out.println("账号或密码错误");
            req.setAttribute("msg", "账号或密码错误");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }

    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        if ("abcde".equalsIgnoreCase(code)) {
            if (userService.existsUsername(user.getUsername())) {
                System.out.println("用户名[" + user.getUsername() + "]已存在!");
                req.setAttribute("msg", "用户名[" + user.getUsername() + "]已存在!");
                req.setAttribute("username", user.getUsername());
                req.setAttribute("email", user.getEmail());
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                userService.registUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            System.out.println("验证码[" + code + "]错误");
            req.setAttribute("msg", "验证码[" + code + "]错误");
            req.setAttribute("username", user.getUsername());
            req.setAttribute("email", user.getEmail());
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
