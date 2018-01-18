package org.frankwork.cloud;

import feign.Param;
import feign.RequestLine;

public interface HelloClient {

	@RequestLine("GET /hello")
	public String hello();
	
	@RequestLine("GET /call/{id}")
	public Police call(@Param("id") Integer id);
}
