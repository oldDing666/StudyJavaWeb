package com.afuya.web;

import com.afuya.pojo.User;
import com.afuya.service.UserService;
import com.afuya.service.impl.UserServiceImpl;
import com.afuya.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author: afuya
 * @program: StudyJavaWebV1
 * @date: 2021/10/18 10:16 上午
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        User loginUser = userService.login(user);
        if (loginUser != null) {
            req.getSession().setAttribute("user", loginUser);
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req, resp);
        } else {
            req.setAttribute("msg", "用户或密码错误！");
            req.setAttribute("username", user.getUsername());
            req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 销毁session
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String code = req.getParameter("code");
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        if (token != null && token.equalsIgnoreCase(code)) {
            if (!userService.existsUsername(user.getUsername())) {
                userService.registUser(user);
                req.getSession().setAttribute("user", user);
                req.getRequestDispatcher("pages/user/regist_success.jsp").forward(req, resp);
            } else {
                req.setAttribute("msg", "用户名已存在！");
                req.setAttribute("username", user.getUsername());
                req.setAttribute("email", user.getEmail());
                req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg", "验证码错误！");
            req.setAttribute("username", user.getUsername());
            req.setAttribute("email", user.getEmail());
            req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
        }
    }
}
