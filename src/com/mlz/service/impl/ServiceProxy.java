package com.mlz.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.hibernate.Session;

import com.mlz.hibernate.util.HibernateUtil;

/**
 * 业务代理
 * @author Administrator
 *
 */
public class ServiceProxy implements InvocationHandler {
	//被代理的业务对象
	private Object target;	
	
	public ServiceProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


		Session session=HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Object retValue=method.invoke(target, args);
			session.getTransaction().commit();
			return retValue;
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw(e);
		}finally {
			session.close();
		}
	}
}
