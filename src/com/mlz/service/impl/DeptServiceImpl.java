package com.mlz.service.impl;

import java.util.List;

import com.mlz.domain.Dept;
import com.mlz.persistence.DeptDao;
import com.mlz.persistence.impl.DeptDaoImpl;
import com.mlz.service.DeptService;

/**
 * 部门业务实现类
 * @author Administrator
 *
 */
public class DeptServiceImpl implements DeptService{
	private DeptDao deptDao=new DeptDaoImpl();
	@Override
	public List<Dept> listAllDepts() {
		return deptDao.findAll();
	}
	@Override
	public boolean deleteDept(Integer no) {
		
		return deptDao.deleteById(no);
	}
	@Override
	public boolean addDept(Dept dept) {		
		return deptDao.save(dept)!=null;
	}
	@Override
	public Dept findDept(Integer no) {
		return deptDao.findById(no);
	}
	@Override
	public boolean updateDept(Dept dept) {
		return deptDao.update(dept)!=null;
	}
	
}
