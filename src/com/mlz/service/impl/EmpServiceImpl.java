package com.mlz.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.mlz.domain.*;
import com.mlz.dto.EmpDto;
import com.mlz.persistence.EmpDao;
import com.mlz.persistence.impl.EmpDaoImpl;
import com.mlz.service.EmpService;
import com.mlz.util.PageBean;

public class EmpServiceImpl implements EmpService {
	EmpDao empDao=new EmpDaoImpl();
	@Override
	public PageBean<EmpDto> listAllEmpsByDeptNo(Dept dept,int page,int size) {
		PageBean<Emp> pageBean= empDao.findEmpsByDept(dept,page,size);
		List<Emp> empList=pageBean.getDataModel();
		List<EmpDto> empDtoList=new ArrayList<>();
		
		for(Emp emp :empList) {
			EmpDto empDto=new EmpDto(emp);
			empDtoList.add(empDto);
		}
		System.out.println(empDtoList.size());
		return new PageBean<EmpDto>(empDtoList,pageBean.getTotalPage(),pageBean.getCurrentPage(),pageBean.getPageSize());
		
	}
	@Override
	public boolean addNewEmp(Emp emp) {
		return empDao.save(emp)!=null;
	}
	@Override
	public boolean removeEmpByNo(Integer no) {
		return empDao.deleteById(no);
	}
	@Override
	public Emp findEmpByNo(Integer no) {
		return empDao.findById(no);
	}
	@Override
	public boolean updateEmpByNo(Emp emp) {
		return empDao.update(emp)!=null;
	}

}
