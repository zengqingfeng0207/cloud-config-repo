package com.frankwork.cloud.security.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(UserNameExistException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> handlerUserNameExistException(UserNameExistException uee){
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("message", uee.getMessage());
		map.put("id", uee.getId());
		return map;
	}
}
