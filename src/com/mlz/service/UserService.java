package com.mlz.service;

import com.mlz.domain.*;
/**
 * 用户想换业务接口
 * @author Administrator
 *
 */
public interface UserService {
	/**
	 * 登陆
	 * @param username
	 * @param password
	 * @return true成功  false失败
	 */
	boolean login(String username,String password);
	/**
	 * 注册
	 * @param user
	 * @return true成功  false失败
	 */
	boolean register(User user);
}
