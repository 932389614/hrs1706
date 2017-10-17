package com.mlz.persistence;

import com.mlz.domain.*;

import com.mlz.util.PageBean;

/**
 * Ա�����ݶ�����ʽӿ�
 * @author Administrator
 *
 */
public interface EmpDao extends BaseDao<Emp, Integer>{
	/**
	 * ���ݲ��ű�Ų���Ա��
	 * @param deptno
	 * @return	��ҳ������
	 */
	PageBean<Emp> findEmpsByDept(Dept dept,int page,int size);
}
