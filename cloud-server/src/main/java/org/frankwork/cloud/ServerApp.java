package org.frankwork.cloud;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerApp {

	public static void main(String[] args) {
		System.out.println("«Î…Ë÷√∂Àø⁄∫≈");
		Scanner sc = new Scanner(System.in);
		String port = sc.nextLine();
		new SpringApplicationBuilder(ServerApp.class).properties("server.port="+port).web(true).run(args);
	}

}
