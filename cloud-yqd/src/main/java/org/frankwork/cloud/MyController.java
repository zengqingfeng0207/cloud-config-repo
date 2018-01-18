package org.frankwork.cloud;
 

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class MyController {
		
	@RequestMapping(value = "/hello/{name}" , method = RequestMethod.GET )
	public String hello(@PathVariable String name){
		return "hello, " +name;
	}
	
	@RequestMapping(value="/call/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Police call(@PathVariable Integer id,HttpServletRequest request){
		Police p = new Police();
		p.setId(id);
		p.setName("frank");
		System.out.println("+++++"+request.getSession().getAttribute("myAttribute"));
		p.setMessage(request.getRequestURL().toString());
		return p;
	}
	
	
	
}
