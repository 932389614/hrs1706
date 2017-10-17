package com.mlz.util;
/**
 * 数据库操作异常
 * @author Administrator
 *
 */
public class DbException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DbException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
