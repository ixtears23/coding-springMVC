package spring.mvc.web.member.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mvc.web.member.dto.Person;

@Controller
@RequestMapping("/web/member")
public class MemberController {
	
	@PreDestroy
	public void beanPre() {
		System.out.println("MemberController @@PreDestroy");
	}
	
	@PostConstruct
	public void beanPost() {
		System.out.println("MemberController @PostConstruct");
	}
	
	@RequestMapping("/")
	public String index() {
		System.out.println("index");
		return "member/index";
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public Person json() {
		Person person = new Person();
		person.setAge(19);
		person.setName("¡ÿºÆ");
		return person; 
	}
}
