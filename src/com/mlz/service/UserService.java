package com.mlz.service;

import com.mlz.domain.*;
/**
 * �û��뻻ҵ��ӿ�
 * @author Administrator
 *
 */
public interface UserService {
	/**
	 * ��½
	 * @param username
	 * @param password
	 * @return true�ɹ�  falseʧ��
	 */
	boolean login(String username,String password);
	/**
	 * ע��
	 * @param user
	 * @return true�ɹ�  falseʧ��
	 */
	boolean register(User user);
}
