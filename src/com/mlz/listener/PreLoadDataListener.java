package com.mlz.listener;

import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mlz.domain.*;
import com.mlz.service.DeptService;
import com.mlz.service.impl.ServiceFacyory;
@WebListener
public class PreLoadDataListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent evt) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(evt);
	}
	/**
	 * ���沿�����ڴ�(ServletContext�����û�����  ������������Ŀһ��)
	 * Mapӳ�䱣��   ʹ�ü�ֱ�Ӳ���  list�����
	 */
	@Override
	public void contextInitialized(ServletContextEvent evt) {
		DeptService deptService=ServiceFacyory.create(DeptService.class);
		List<Dept> deptList=deptService.listAllDepts();
		Map<Integer,Dept> cacheMap=new HashMap<>();
		for(Dept dept:deptList) {
			cacheMap.put(dept.getId(), dept);
		}
		ServletContext servletContext=evt.getServletContext();
		servletContext.setAttribute("deptCache", cacheMap);
	}
}
