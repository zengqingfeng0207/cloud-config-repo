package com.frankwork.cloud.security.demo.server.impl;

import org.springframework.stereotype.Service;

import com.frankwork.cloud.security.demo.bean.UserInfo;
import com.frankwork.cloud.security.demo.server.UserServer; 
@Service
public class UserServerImpl implements UserServer {

	@Override
	public UserInfo getUserInfoByName(String name) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(name);
		return userInfo;
	}

}
