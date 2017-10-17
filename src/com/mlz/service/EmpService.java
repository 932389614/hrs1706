package com.mlz.service;


import com.mlz.domain.*;
import com.mlz.dto.EmpDto;
import com.mlz.util.PageBean;
/**
 * Ա�����ҵ��ӿ�
 * @author Administrator
 *
 */
public interface EmpService {
	/**
	 * ���ز��ŵ��밺
	 * @param deptno	���ű��
	 * @return	Ա���б�����
	 */
	PageBean<EmpDto> listAllEmpsByDeptNo(Dept dept,int page,int size);
	
	boolean addNewEmp(Emp emp);
	
	boolean removeEmpByNo(Integer no);
	
	Emp findEmpByNo(Integer no);
	
	boolean updateEmpByNo(Emp emp);
}
