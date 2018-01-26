package com.frankwork.cloud.security.demo.wiremock;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import com.github.tomakehurst.wiremock.client.WireMock;

public class MockServer {

	public static void main(String[] args) throws IOException {
		 
		WireMock.configureFor("127.0.0.1",8060);
		WireMock.removeAllMappings();
		
		mock("/user/1","usre01");
		mock("/user/2","usre02");
	}
	
	public static void mock(String url,String file) throws IOException {
		ClassPathResource resource = new ClassPathResource("mock/response/"+file+".txt");
		String content = StringUtils.join(FileUtils.readLines(resource.getFile(),"UTF-8").toArray(),"\n");
		
		
		WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo(url))
				.willReturn(
						WireMock.aResponse().withBody(content).withStatus(200)
						));
		
		
//		WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo(url))
//				.willReturn(
//						WireMock.aResponse().withBody("{\"id\":01}").withStatus(200)
//						));
	}

}
