package com.frankwork.cloud.security.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.frankwork.cloud.security.demo.bean.UserInfo;
import com.frankwork.cloud.security.demo.server.UserServer;

public class MyConstraintValidator implements ConstraintValidator<MyUserConstraint, Object> {

	@Override
	public void initialize(MyUserConstraint arg0) {
		System.out.println("校验初始化方法");
		
	}

	
	@Autowired
	private UserServer userServer;
	
	@Override
	public boolean isValid(Object arg0, ConstraintValidatorContext arg1) {
		//校验方法  返回校验结果
		UserInfo userInfo = userServer.getUserInfoByName(arg0.toString());
		//数据库中不存在
		if(userInfo==null) {
			return true;
		}
		//测试，未连接数据库
		if(userInfo.getUsername().equals("frank"))
			return false;
		return true;
		
	}

}
