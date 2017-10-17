package com.mlz.persistence;

import com.mlz.domain.*;

import com.mlz.util.PageBean;

/**
 * 员工数据对象访问接口
 * @author Administrator
 *
 */
public interface EmpDao extends BaseDao<Emp, Integer>{
	/**
	 * 根据部门编号查找员工
	 * @param deptno
	 * @return	分页器对象
	 */
	PageBean<Emp> findEmpsByDept(Dept dept,int page,int size);
}
