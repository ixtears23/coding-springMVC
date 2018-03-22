package spring.mvc.web.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mvc.web.member.dto.Person;

@Controller
@Order(5)
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
	
	@GetMapping(value="/practice")
	public String practice() {
		System.out.println("index");
		return "member/practice";
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public Person json() {
		Person person = new Person();
		person.setAge(19);
		person.setName("¡ÿºÆ");
		return person; 
	}
	
	
	@PostMapping("/ajaxPost.json")
	public @ResponseBody Map<String, String>  ajaxPost(@RequestBody HashMap<String, String> params){
		
		Map<String, String> resMap = new HashMap<String, String>();
		resMap.put("id", "Oh");
		resMap.put("name", "dori");
		
		return resMap;
	}
}
