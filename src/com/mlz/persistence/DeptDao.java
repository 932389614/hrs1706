package com.mlz.persistence;

import com.mlz.domain.Dept;


public interface DeptDao extends BaseDao<Dept, Integer>{
	/**
	 * 查询部门人数
	 * @param no	部门编号
	 * @return 	部门人数
	 */
	int countEmpByNo(Integer no);

}
