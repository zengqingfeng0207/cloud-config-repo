package org.frankwork.cloud;
 

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 

@FeignClient("yqd")
public interface FeignInterface {
	
	@RequestMapping(value="/call/{id}",method = RequestMethod.GET) 
	public Police call(@PathVariable("id") Integer id);
	
}
