package com.mlz.controllor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mlz.service.UserService;

@WebServlet(urlPatterns="/login",loadOnStartup=1)
public class LoginServlet extends BaseServlet {
	private UserService userService=getUserService();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		if(!username.equals("") && !password.equals("")) {
			if(userService.login(username, password)) {
				//回话中保存用户名  用于判断用户是否登楼
				req.getSession().setAttribute("username", username);
				resp.sendRedirect("dept?method=list");
			}else {
				req.setAttribute("hint", "用户名或密码错误");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		}else{
			req.setAttribute("hint", "请输入有效的登录信息");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
