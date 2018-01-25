package com.frankwork.cloud.security.demo.server;

import com.frankwork.cloud.security.demo.bean.UserInfo;

public interface UserServer {

	public UserInfo getUserInfoByName(String name);
}
