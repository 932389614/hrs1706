package com.mlz.persistence.impl;
import java.util.List;

import com.mlz.domain.Dept;
import com.mlz.domain.Emp;
import com.mlz.hibernate.util.HibernateUtil;
import com.mlz.persistence.EmpDao;
import com.mlz.util.PageBean;

public class EmpDaoImpl extends BaseDaoAdapter<Emp, Integer> implements EmpDao {

	/*@Override
	public boolean save(Emp entity) {
		return HibernateUtil.getSession().save(entity)!=null;
	}

	@Override
	public boolean deleteById(Integer id) {
		return HibernateUtil.getSession().createQuery("delete from Emp as e where e.no=:no")
				.setParameter("no", id).executeUpdate()==1;
	}

	@Override
	public boolean update(Emp entity) {
		return HibernateUtil.getSession().merge(entity)!=null;
	}

	@Override
	public Emp findById(Integer id) {
		return HibernateUtil.getSession().get(Emp.class, id);
	}*/

	@Override
	public PageBean<Emp> findEmpsByDept(Dept dept, int page, int size) {
		List<Emp> empList=HibernateUtil.getSession().createQuery("from Emp as e where e.dept=:dept")
				.setParameter("dept", dept)
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.getResultList();
		int empCount=HibernateUtil.getSession().createQuery("select count(e) from Emp as e where e.dept=:dept",Long.class)
				.setParameter("dept", dept).getSingleResult().intValue();
		int totalPage=(empCount-1)/size+1;
		return new PageBean<Emp>(empList,totalPage,page,size);
		
	}
	
}
