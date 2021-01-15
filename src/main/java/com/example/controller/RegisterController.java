package com.example.controller;

import com.example.dao.AdminDao;
import com.example.dao.RegisterDao;
import com.example.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

public class RegisterController extends HttpServlet {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private RegisterDao registerDao;

    @RequestMapping("/")
    public void register(HttpServletResponse response,HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("utf-8");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");
        String phoneNumber = request.getParameter("phoneNumber");
        String gender = request.getParameter("gender");
        String birthDay = request.getParameter("birthDay");

        //判断账号是否存在
        List<Users> userList = adminDao.checkAccount(account);
        if (userList.size() != 0) {
            response.sendRedirect("register.jsp?st=1");
        } else {
            //添加新账号
            Users user = new Users();
            user.setAccount(account);
            user.setPassword(password);
            user.setBirthDay(birthDay);
            if ("1".equals(gender)) {
                gender = "男";
            } else {
                gender = "女";
            }
            user.setGender(gender);
            user.setPhoneNumber(phoneNumber);
            user.setUserName(userName);
            user.setUserStatus("3");
            String userId = UUID.randomUUID().toString().substring(0, 8);
            user.setUserId(userId);

            registerDao.registerNewMember(user);

            response.sendRedirect("login.jsp");
        }
    }

}
