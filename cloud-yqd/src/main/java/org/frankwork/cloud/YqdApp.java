package org.frankwork.cloud;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(ReceiveService.class)
public class YqdApp {

	public static void main(String[] args) {
		System.out.println("请设置端口号:");
		Scanner sc = new Scanner(System.in);
		String port = sc.nextLine();
		 new SpringApplicationBuilder(YqdApp.class).properties("server.port="+port).web(true).run(args);
	}

	@StreamListener("myInput")
	public void onReceive(byte[] mes){
		String message = new String(mes);
		System.out.println("收到rabbitMQ的信息："+message);
	}
}
