package com.mlz.persistence.impl;
import com.mlz.domain.User;
import com.mlz.persistence.UserDao;


/**
 * �û���Ϣ�־û�ʵ��
 * @author Administrator
 *
 */
public class UserDaoImpl extends BaseDaoAdapter<User, String> implements UserDao {

/*	@Override
	public boolean save(User entity) {
		return HibernateUtil.getSession().save(entity)!=null;
	}


	@Override
	public User findById(String id) {
		return HibernateUtil.getSession().get(User.class, id);
	}

	*/
}
