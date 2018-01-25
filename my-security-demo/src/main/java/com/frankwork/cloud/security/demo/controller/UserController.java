package com.frankwork.cloud.security.demo.controller;
 
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.frankwork.cloud.security.demo.UserQueryInfo;
import com.frankwork.cloud.security.demo.bean.UserInfo;
import com.frankwork.cloud.security.demo.bean.UserInfo.UserInfoNameAndPassView;
import com.frankwork.cloud.security.demo.bean.UserInfo.UserInfoNameView;
 

@RestController
public class UserController {


	@GetMapping("/user")
	@JsonView(UserInfo.UserInfoNameView.class)
	public List<UserInfo> getUserInfo(){
		List<UserInfo> list = new ArrayList<>();
		list.add(new UserInfo());
		list.add(new UserInfo());
		list.add(new UserInfo());
		return list;
	}
	
	
	
	
	@GetMapping("/users")
	@JsonView(UserInfo.UserInfoNameView.class)
	public List<UserInfo> getUserInfos(UserQueryInfo queryInfo,@PageableDefault(page=2,size=15,sort="age,desc") Pageable pageable){
		System.out.println(ReflectionToStringBuilder.toString(queryInfo,ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(ReflectionToStringBuilder.toString(pageable,ToStringStyle.MULTI_LINE_STYLE));
		List<UserInfo> list = new ArrayList<>();
		UserInfo user =new UserInfo();
		user.setUsername("frank");
		list.add(user);
		list.add(user);
		list.add(user);
		return list;
	}
	
	@GetMapping("/user/{id:\\d*}")
	@JsonView(UserInfo.UserInfoNameAndPassView.class)
	public UserInfo getUserInfoById(@PathVariable Integer id){
		UserInfo user = new UserInfo();
		System.out.println(id);
		user.setUsername("frank");
		return user;
	}
	
	@PostMapping
	public UserInfo createUser(@Valid @RequestBody UserInfo user ,BindingResult errors) {
		
		if(errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
		}
		
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		user.setId(1);
		return user;
	}
	
	@DeleteMapping("/user/{id:\\d+}")
	public void delUserInfo(@PathVariable Integer id) {
		UserInfo user = new UserInfo();
		user.setId(id);
		System.out.println(user.getId());
	}
}
