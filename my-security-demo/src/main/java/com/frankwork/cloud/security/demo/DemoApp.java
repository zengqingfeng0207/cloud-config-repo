package com.frankwork.cloud.security.demo;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApp {

	private static Scanner sc;

	public static void main(String[] args) {
//		System.out.println("请输入端口号:");
//		sc = new Scanner(System.in);
//		String port = sc.nextLine();
		new SpringApplicationBuilder(DemoApp.class).web(true).run(args);
	}

	@RequestMapping(name="/hello",method = RequestMethod.GET)
	public String hello() {
		return "hello my spring security";
	}
	
}
