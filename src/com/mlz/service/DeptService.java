package com.mlz.service;

import java.util.List;

import com.mlz.domain.Dept;

/**
 * �������ҵ��ӿ�
 * @author Administrator
 *
 */
public interface DeptService {
	/**
	 * �г����в���
	 * @return ���沿�ŵ�����
	 */
	List<Dept> listAllDepts();
	
	boolean deleteDept(Integer no);
	
	boolean addDept(Dept dept);
	
	Dept findDept(Integer no);
	
	boolean updateDept(Dept dept);
}
