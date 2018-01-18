package org.frankwork.cloud;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableBinding(SendService.class)
public class ClientApp {

	public static void main(String[] args) {
		
		System.out.println("«Î…Ë÷√∂Àø⁄∫≈:");
		Scanner sc = new Scanner(System.in);
		String port = sc.nextLine();
		 new SpringApplicationBuilder(ClientApp.class).properties("server.port="+port).web(true).run(args);
		 

	}

}
