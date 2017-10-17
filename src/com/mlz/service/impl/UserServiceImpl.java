package com.mlz.service.impl;

import org.apache.commons.codec.digest.DigestUtils;

import com.mlz.domain.User;
import com.mlz.persistence.*;
import com.mlz.persistence.impl.UserDaoImpl;
import com.mlz.service.UserService;
/**
 * 用户业务实现类
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService{
	private UserDao userDao=new UserDaoImpl();
	@Override
	public boolean login(String username, String password) {
		User temp=userDao.findById(username);
		if(temp!=null) {
			String md5=DigestUtils.md5Hex(password);
			return temp.getPassword().equals(md5);
		}
		return false;
	}

	@Override
	public boolean register(User user) {
		if(userDao.findById(user.getUsername())==null) {			
			user.setPassword(DigestUtils.md5Hex(user.getPassword()));			
			return userDao.save(user)!=null;
		}
		else 
			return false;
	}

}
