package com.frankwork.cloud.security.demo.bean;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;
import com.frankwork.cloud.security.demo.validator.MyUserConstraint;

public class UserInfo {

	public interface UserInfoNameView{};
	
	public interface UserInfoNameAndPassView extends UserInfoNameView{};
	@MyUserConstraint
	private String username;
	
	private Integer id;
	@NotBlank(message="密码不能为空")
	private String password;
	@JsonView(UserInfoNameView.class)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@JsonView(UserInfoNameAndPassView.class)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@JsonView(UserInfoNameView.class)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
