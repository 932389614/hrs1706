package com.mlz.persistence;

import com.mlz.domain.Dept;


public interface DeptDao extends BaseDao<Dept, Integer>{
	/**
	 * ��ѯ��������
	 * @param no	���ű��
	 * @return 	��������
	 */
	int countEmpByNo(Integer no);

}
