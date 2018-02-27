package spring.mvc.web.login.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@PreDestroy
	public void beanPre() {
		System.out.println("LoginController @@PreDestroy");
	}
	
	@PostConstruct
	public void beanPost() {
		System.out.println("LoginController @PostConstruct");
	}
	@RequestMapping("/web")
	public String index() {
		return "index";
	}
}
