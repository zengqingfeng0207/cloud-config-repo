package org.frankwork.cloud;

import feign.Feign;

public class FeignController {

	public static void main(String[] args) {
		HelloClient client = Feign.builder().target(HelloClient.class, "http://localhost:8080");
		String str = client.hello();
		System.out.println(str);
	}
}
