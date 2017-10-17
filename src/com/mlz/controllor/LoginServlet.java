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
				//�ػ��б����û���  �����ж��û��Ƿ��¥
				req.getSession().setAttribute("username", username);
				resp.sendRedirect("dept?method=list");
			}else {
				req.setAttribute("hint", "�û������������");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		}else{
			req.setAttribute("hint", "��������Ч�ĵ�¼��Ϣ");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
