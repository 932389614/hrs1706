package com.mlz.controllor;

import javax.servlet.http.HttpServlet;

import com.mlz.service.*;
import com.mlz.service.impl.ServiceFacyory;
/**
 * 所有自定义servlet父类
 * @author Administrator
 *
 */
public abstract class BaseServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 获取用户业务对象
	 * @return 用户业务对象
	 */
	protected UserService getUserService() {
		return ServiceFacyory.create(UserService.class);		
	}
	/**
	 * 获取部门业务对象
	 * @return	部门业务对象
	 */
	protected DeptService getDeptService() {
		return ServiceFacyory.create(DeptService.class);		
	}
	/**
	 * 获得员工业务对象
	 * @return	员工业务对象
	 */
	protected EmpService getEmpService() {
		return ServiceFacyory.create(EmpService.class);		
	}
}
