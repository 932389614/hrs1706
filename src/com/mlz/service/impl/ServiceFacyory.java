package com.mlz.service.impl;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import com.mlz.service.*;

public final class ServiceFacyory {
	public static Map<Class<?>,Object> map= new HashMap<>();
	static {
		UserService userService=createProxy(new UserServiceImpl());
		DeptService deptService=createProxy(new DeptServiceImpl());
		EmpService empService=createProxy(new EmpServiceImpl());
		
		map.put(UserService.class,userService);
		map.put(DeptService.class,deptService);
		map.put(EmpService.class,empService);
	}
	private ServiceFacyory(){
		throw new AssertionError();
	}
	/**
	 * 创建业务对象
	 * @param type	业务对象类型
	 * @return	业务对象
	 */
	public static <T> T create(Class<?> type) {		
		return (T) map.get(type);	
	}
	
	public static <T> T createProxy(Object target) {
		return (T) Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				new ServiceProxy(target));	
	}
	
}
