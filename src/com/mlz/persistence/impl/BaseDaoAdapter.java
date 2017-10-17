package com.mlz.persistence.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.mlz.hibernate.util.HibernateUtil;
import com.mlz.persistence.BaseDao;

public class BaseDaoAdapter <E,K extends Serializable> implements BaseDao<E, K>{
	private Class<E> entityType;
	private String entityName;
	protected BaseDaoAdapter(){
		//��ȡ�����͵ĸ���
		ParameterizedType pt= (ParameterizedType) this.getClass().getGenericSuperclass();
		//ͨ�������͵ĸ����ȡ��ʵ�����Ͳ�������
		entityType=(Class<E>) pt.getActualTypeArguments()[0];
		//��ȡ����������������
		entityName=entityType.getSimpleName();
	}
	
	@Override
	public K save(E entity) {
		// TODO Auto-generated method stub
		return (K) HibernateUtil.getSession().save(entity);
	}

	@Override
	public boolean deleteById(K id) {
		// TODO Auto-generated method stub
		return HibernateUtil.getSession()
				.createQuery("delete from "+entityName+" as o where o.id=:id")
				.setParameter("id", id).executeUpdate()==1;
	}

	@Override
	public E update(E entity) {
		return (E) HibernateUtil.getSession().merge(entity);
	}

	@Override
	public E findById(K id) {
		return HibernateUtil.getSession().get(entityType,id);
	}

	@Override
	public List<E> findAll() {
		return HibernateUtil.getSession()
				.createQuery("from "+entityName).getResultList();
	}
}
