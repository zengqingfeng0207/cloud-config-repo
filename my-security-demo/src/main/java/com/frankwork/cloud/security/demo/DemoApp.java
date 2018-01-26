package com.frankwork.cloud.security.demo;
 

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableSwagger2
public class DemoApp {

//	private static Scanner sc;

	public static void main(String[] args) {
//		System.out.println("请输入端口号:");
//		sc = new Scanner(System.in);
//		String port = sc.nextLine();
		new SpringApplicationBuilder(DemoApp.class).web(true).run(args);
	}
 
}
