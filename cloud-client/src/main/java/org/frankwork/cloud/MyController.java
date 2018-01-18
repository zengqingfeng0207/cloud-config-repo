package org.frankwork.cloud;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean; 
import org.springframework.core.env.Environment;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class MyController {

	@Autowired
	public FeignInterface feignInterface;
	
//	@LoadBalanced
//	@Bean
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}
//	
//	@RequestMapping("/hello")
//	public String hello(){
//		RestTemplate temp  = restTemplate();
//		String json = temp.getForObject("http://yqd/hello/Frank", String.class);
//		return json;
//	}
//	
//	@RequestMapping(value="/call114/{id}" ,method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public String call114(@PathVariable Integer id){
//		RestTemplate temp  = restTemplate(); 
//		String json = temp.getForObject("http://yqd/call/"+id, String.class);
//		return json;
//	}
	
//	@RequestMapping(value="/call/{id}" ,method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
//	public Police call(@PathVariable Integer id,HttpServletRequest request ){
//	 
//		Police p =feignInterface.call(id); 
//		return p;
//	}
	
	
//	@Autowired
//	private SendService sendService;
//	
//	@RequestMapping(value="/send/{hello}" ,method = RequestMethod.GET)
//	@ResponseBody
//	public String send(@PathVariable String hello){
//		
//		Message<byte[]> message = MessageBuilder.withPayload(hello.getBytes()).build();
//		
//		sendService.sendOrder().send(message);
//		
//		return "success";
//	}
 
	@Autowired
	private Environment env;
	
	@RequestMapping(value="/getConfig/{proName}" ,method = RequestMethod.GET)
	@ResponseBody
	public String getConfig(@PathVariable String proName){
		String userName="";
		userName = env.getProperty(proName);
		System.out.println(proName+"-----"+userName+"*-----");
		return userName;
	}
	
}
