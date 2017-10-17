package com.mlz.service;

import java.util.List;

import com.mlz.domain.Dept;

/**
 * 部门相关业务接口
 * @author Administrator
 *
 */
public interface DeptService {
	/**
	 * 列出所有部门
	 * @return 保存部门的容器
	 */
	List<Dept> listAllDepts();
	
	boolean deleteDept(Integer no);
	
	boolean addDept(Dept dept);
	
	Dept findDept(Integer no);
	
	boolean updateDept(Dept dept);
}
