package com.mlz.controllor;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.alibaba.fastjson.JSON;
import com.mlz.domain.Dept;
import com.mlz.domain.Emp;
import com.mlz.dto.EmpDto;
import com.mlz.service.EmpService;

import com.mlz.util.CommonUtil;
import com.mlz.util.PageBean;


@WebServlet("/emp")
@MultipartConfig(maxFileSize=10*1024*1024)
public class EmpServlet extends BaseServlet {
	private static final int DEFAULT_IMAGE_HEIGHT = 150;
	private static final int DEFAULT_IMAGE_WIDTH = 200;
	private static final int DEFAULT_PAGE=1;
	private static final int DEFAULT_SIZE=5;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EmpService empService=getEmpService();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method=req.getParameter("method");
		System.out.println("method"+method);
		try {
			if(method!=null) {
				Method m=this.getClass().getMethod(method, HttpServletRequest.class,HttpServletResponse.class);
				if(m!=null)
					m.invoke(this, req,resp);
			}
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
	public void empInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer empno=Integer.valueOf(req.getParameter("no"));	
		req.setAttribute("emp", empService.findEmpByNo(empno));
		System.out.println(empService.findEmpByNo(empno));
		req.getRequestDispatcher("empInfo.jsp").forward(req, resp);
	}
	public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer empno=Integer.valueOf(req.getParameter("no"));	
		System.out.println(empno);
		req.setAttribute("emp", empService.findEmpByNo(empno));
		System.out.println(empService.findEmpByNo(empno));
		req.getRequestDispatcher("empedit.jsp").forward(req, resp);
	}
	public void updateemp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer deptno=Integer.valueOf(req.getParameter("deptno"));
		Dept dept=(Dept)req.getSession().getAttribute("dept");
		Emp emp=createmp(req, resp);
		empService.updateEmpByNo(emp);
		req.setAttribute("deptno", deptno);
		PageBean<EmpDto> page=empService.listAllEmpsByDeptNo(dept,DEFAULT_PAGE,DEFAULT_SIZE);
		req.setAttribute("empList", page.getDataModel());
		req.setAttribute("totalPage", page.getTotalPage());
		req.setAttribute("currentPage", page.getCurrentPage());
		req.getRequestDispatcher("emp.jsp").forward(req, resp);
	}
	public void deptEmpList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer deptno=Integer.valueOf(req.getParameter("deptno"));	
		Integer pageNo=Integer.valueOf(req.getParameter("page"));	
		Dept dept=(Dept)req.getSession().getAttribute("dept");
		if(dept==null || deptno!=dept.getId()) {
			dept=getDeptService().findDept(deptno);
			req.getSession().setAttribute("dept", dept);
		}
		if(pageNo<=0)
			pageNo=DEFAULT_PAGE;
		System.out.println(dept.getName());
		System.out.println(pageNo);
		PageBean<EmpDto> page=empService.listAllEmpsByDeptNo(dept,pageNo,DEFAULT_SIZE);
		req.setAttribute("empList", page.getDataModel());
		req.setAttribute("totalPage", page.getTotalPage());
		req.setAttribute("currentPage", page.getCurrentPage());
		req.setAttribute("deptName", req.getParameter("deptName"));
	//	req.getRequestDispatcher("emp.jsp").forward(req, resp);
		req.getRequestDispatcher("emp.jsp").forward(req, resp);

		
	}
	public void deptAjaxEmpList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer pageNo=Integer.valueOf(req.getParameter("page"));	
		Dept dept=(Dept)req.getSession().getAttribute("dept");
		if(pageNo<=0)
			pageNo=DEFAULT_PAGE;
		System.out.println("pageNo"+pageNo);
		PageBean<EmpDto> page=empService.listAllEmpsByDeptNo(dept,pageNo,DEFAULT_SIZE);
		String jsonStr=JSON.toJSONString(page);
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.write(jsonStr);
		pw.close();
	}
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer no=Integer.valueOf(req.getParameter("no"));		
		Emp emp=empService.findEmpByNo(no);
		emp.setStatus(false);
		String repinseText=empService.updateEmpByNo(emp)?"success":"failed";	
		System.out.println(repinseText);
		PrintWriter pw=resp.getWriter(); 
		pw.write(repinseText);
		pw.close();
	}
	public void newemp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Emp emp=createmp(req,resp);
		Dept dept=(Dept)req.getSession().getAttribute("dept");
		Integer deptno=Integer.valueOf(req.getParameter("deptno"));
		if(getEmpService().addNewEmp(emp)) {	
			req.setAttribute("deptno", deptno);
			PageBean<EmpDto> page=empService.listAllEmpsByDeptNo(dept,DEFAULT_PAGE,DEFAULT_SIZE);
			req.setAttribute("empList", page.getDataModel());
			req.setAttribute("totalPage", page.getTotalPage());
			req.setAttribute("currentPage", page.getCurrentPage());
			req.getRequestDispatcher("emp.jsp").forward(req, resp);
		}else {
			req.setAttribute("hint", "添加员工失败");
			req.getRequestDispatcher("empadd.jsp").forward(req, resp);			
		}		
	}
	
	public  Emp createmp(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Integer no=Integer.valueOf(req.getParameter("no"));
		String name=req.getParameter("name");
		boolean sex=req.getParameter("sex").equals("1");
		String job=req.getParameter("job");
		Double salary=Double.valueOf(req.getParameter("salary"));
		Date hirDate=CommonUtil.stringToDate("yyyy-MM-dd", req.getParameter("hirdate"));
		String tel=req.getParameter("tel");
		Integer deptno=Integer.valueOf(req.getParameter("deptno"));
		String mgr=req.getParameter("mgr");		
		
		
		Emp emp=new Emp();
		emp.setId(no);
		emp.setName(name);
		emp.setSex(sex);
		emp.setJob(job);
		emp.setSalary(salary);
		emp.setStatus(true);
		emp.setHirDate(hirDate);
		int mgrno= mgr==null?0:Integer.valueOf(mgr);
		emp.setMgr(getEmpService().findEmpByNo(mgrno));
		emp.setTel(tel);
		emp.setDept(getDeptService().findDept(deptno));
		
		//文件上传
		Part part=req.getPart("photo");
		//获取文件名
		if(part.getSize()>0) {
			
			String originalName=part.getSubmittedFileName();
			//生成唯一的文件名
			String newFilename=CommonUtil.getUniqueFilename()+CommonUtil.getFilenameSuffix(originalName);
			String path=req.getServletContext().getRealPath("/images");
			
			File file=new File(path+"/"+newFilename);
			InputStream inputStream=part.getInputStream();
			CommonUtil.compressImage(inputStream, file, DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT);
			System.out.println(file.toString());
		//	part.write(path+"/"+newFilename);
			emp.setPhoto(newFilename);
		}
		return emp;
	}
}
