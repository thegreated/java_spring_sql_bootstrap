package com.accenture.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
		
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you learning today 2";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<body>");
		sb.append("<h2>test 2 32 12 1212 </h2>");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
	
	//JSP
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	
	@RequestMapping("say-hello-jsp")
	public String sayJsp() {
		return "sayHello";
	}
	
	
	

}
