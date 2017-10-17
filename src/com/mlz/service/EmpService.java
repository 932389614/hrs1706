package com.mlz.service;


import com.mlz.domain.*;
import com.mlz.dto.EmpDto;
import com.mlz.util.PageBean;
/**
 * 员工相关业务接口
 * @author Administrator
 *
 */
public interface EmpService {
	/**
	 * 返回部门的与昂
	 * @param deptno	部门编号
	 * @return	员工列表容器
	 */
	PageBean<EmpDto> listAllEmpsByDeptNo(Dept dept,int page,int size);
	
	boolean addNewEmp(Emp emp);
	
	boolean removeEmpByNo(Integer no);
	
	Emp findEmpByNo(Integer no);
	
	boolean updateEmpByNo(Emp emp);
}
