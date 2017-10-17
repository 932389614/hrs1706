package com.mlz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req=(HttpServletRequest)request;
		String serveletPath=req.getServletPath();
		System.out.println(serveletPath);
		if(serveletPath.contains("dept") || serveletPath.contains("emp")) {
			if(req.getSession().getAttribute("username")!=null) {
				chain.doFilter(request, response);		
			}else {
				HttpServletResponse resp=(HttpServletResponse)response;
				resp.sendRedirect("login.jsp");
			}

		}		
		else
			chain.doFilter(request, response);

	}

}
