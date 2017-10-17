package com.mlz.controllor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mlz.domain.User;
import com.mlz.service.UserService;


/**
 * Servlet implementation class regist
 */
@WebServlet("/regist")
public class RegistServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService=getUserService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		if(username.equals("") || password.equals("")|| email.equals("")) {
			req.setAttribute("hint", "请输入有效的注册信息");
			req.getRequestDispatcher("regist.jsp").forward(req, resp);
			return;
		}			
		User user=new User(username,password,email);
		if(userService.register(user)) {
			resp.sendRedirect("login.jsp");
		}
		else{
			req.setAttribute("hint", "请输入有效的注册信息");
			req.getRequestDispatcher("regist.jsp").forward(req, resp);
		}
	}


}
