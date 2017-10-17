package com.mlz.controllor;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mlz.domain.Dept;
import com.mlz.service.DeptService;
@WebServlet(urlPatterns="/dept",loadOnStartup=1)
public class DeptServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DeptService deptService= getDeptService();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	req.setCharacterEncoding("utf-8");
		String method=req.getParameter("method");
		
		try {
			System.out.println(method);
			Method m=this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			if(m!=null)
				m.invoke(this, req,resp);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void newdept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no=req.getParameter("no");
		String name=req.getParameter("name");
		String loction=req.getParameter("location");
		
		if(no.equals("") |name.equals("") |loction.equals("")) {
			req.setAttribute("hint", "请输入有效的部门信息");
			req.getRequestDispatcher("deptadd.jsp").forward(req, resp);
		}else {
			Dept dept=new Dept(Integer.valueOf(no),name,loction);
			if(deptService.addDept(dept)) {
				Map<Integer,Dept> map=(Map<Integer,Dept>)req.getServletContext().getAttribute("deptCache");
				map.put(dept.getNo(), dept);
				req.getServletContext().setAttribute("deptCache", map);
				System.out.println("map.size()"+map.size());
			}
			list(req, resp);
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer no=Integer.valueOf(req.getParameter("no"));
		boolean flag=deptService.deleteDept(no);
		String repinseText=flag?"success":"failed";	
		if(flag) {
			Map<Integer,Dept> map=(Map<Integer,Dept>)req.getServletContext().getAttribute("deptCache");
			map.remove(no);
			req.getServletContext().setAttribute("deptCache", map);
		}
		System.out.println(repinseText);
		PrintWriter pw=resp.getWriter();
		pw.write(repinseText);
		pw.close();
	//	list(req, resp);
	}
	public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<Integer,Dept> map=(Map<Integer,Dept>)req.getServletContext().getAttribute("deptCache");
		List<Dept> deptList=new ArrayList<Dept>();
		for(Integer deptNo:map.keySet()) {
			deptList.add(map.get(deptNo));
		}
		req.setAttribute("deptList", deptList);
		req.getRequestDispatcher("dept.jsp").forward(req, resp);
	}
	public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("editdept", deptService.findDept(Integer.valueOf(req.getParameter("no"))));
		req.getRequestDispatcher("deptadd.jsp").forward(req, resp);
	}
	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer no=Integer.valueOf(req.getParameter("no"));
		String name=req.getParameter("name");
		String location=req.getParameter("location");
		Dept dept=new Dept(no,name,location);
		if(deptService.updateDept(dept)) {
			Map<Integer,Dept> map=(Map<Integer,Dept>)req.getServletContext().getAttribute("deptCache");
			map.put(no, dept);
			req.getServletContext().setAttribute("deptCache", map);
		}
		list(req, resp);
	}
}
