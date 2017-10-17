package com.mlz.persistence.impl;

import com.mlz.domain.Dept;
import com.mlz.persistence.DeptDao;

/**
 * 部门数据访问对象实现类
 * @author Administrator
 *
 */
public class DeptDaoImpl extends BaseDaoAdapter<Dept, Integer> implements DeptDao {

	@Override
	public int countEmpByNo(Integer no) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
