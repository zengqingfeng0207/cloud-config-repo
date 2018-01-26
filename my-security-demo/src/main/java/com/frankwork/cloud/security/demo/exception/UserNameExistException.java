package com.frankwork.cloud.security.demo.exception;

public class UserNameExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6568616970619149112L;
	
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public UserNameExistException(Integer id) {
		super("用户名已存在");
		this.id = id;
	}
	
}
