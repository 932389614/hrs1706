package com.mlz.controllor;

import javax.servlet.http.HttpServlet;

import com.mlz.service.*;
import com.mlz.service.impl.ServiceFacyory;
/**
 * �����Զ���servlet����
 * @author Administrator
 *
 */
public abstract class BaseServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ��ȡ�û�ҵ�����
	 * @return �û�ҵ�����
	 */
	protected UserService getUserService() {
		return ServiceFacyory.create(UserService.class);		
	}
	/**
	 * ��ȡ����ҵ�����
	 * @return	����ҵ�����
	 */
	protected DeptService getDeptService() {
		return ServiceFacyory.create(DeptService.class);		
	}
	/**
	 * ���Ա��ҵ�����
	 * @return	Ա��ҵ�����
	 */
	protected EmpService getEmpService() {
		return ServiceFacyory.create(EmpService.class);		
	}
}
