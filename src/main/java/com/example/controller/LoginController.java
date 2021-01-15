package com.example.controller;

import com.example.dao.AdminDao;
import com.example.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

	@Autowired
	private AdminDao adminDao;

	@RequestMapping("/")
	public String welcome() {
		return "login";
	}
	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println("再次发送请求");
		String account = request.getParameter("account");
		String password = request.getParameter("password");

		Users users = new Users();
		users.setAccount(account);
		users.setPassword(password);

		List<Users> userInfo = adminDao.login(users);

		if (userInfo.size() != 0) {
			HttpSession session = request.getSession();
			Users user = userInfo.get(0);
			System.out.println(user);
			session.setAttribute("user", user);
			System.out.println("登录成功");
			response.sendRedirect("mainPage");
		} else {
			System.out.println("登录失败");
			response.sendRedirect("login.jsp?st=1");
		}
	}
	@RequestMapping("/findAll")
	public void findAll(){
		List<Users> all = adminDao.findAll();
		System.out.println(all);
	}



}
