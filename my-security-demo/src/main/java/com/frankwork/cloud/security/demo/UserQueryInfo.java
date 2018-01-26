package com.frankwork.cloud.security.demo;

import io.swagger.annotations.ApiModelProperty;

public class UserQueryInfo {

	private String username;
	@ApiModelProperty(value="用户年龄起始时间")
	private Integer age;
	@ApiModelProperty(value="用户年龄结束时间")
	private Integer ageTo;
	private String xxx;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getAgeTo() {
		return ageTo;
	}
	public void setAgeTo(Integer ageTo) {
		this.ageTo = ageTo;
	}
	public String getXxx() {
		return xxx;
	}
	public void setXxx(String xxx) {
		this.xxx = xxx;
	}
	
	
}
