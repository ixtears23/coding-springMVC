package spring.mvc.web.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web/memberRest")
@Order(3)
public class MemberRestController {
	
	@PreDestroy
	public void beanPre() {
		System.out.println("MemberRestController @@PreDestroy");
	}
	
	@PostConstruct
	public void beanPost() {
		System.out.println("MemberRestController @PostConstruct");
	}
	
	@PostMapping("/getMember")
	public Map<String, String> getMember(Map<String, String> reqMap){
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("id", "dori");
		map.put("name", "오준석");
		map.put("age", "23");
		map.put("addr", "대전");
		
		return map;
	}

	
	@PostMapping("/getMemberSecond")
	public Map<String, String> getMemberSecond(){
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("id", "hyesoo");
		map.put("name", "김혜수");
		map.put("age", "23");
		map.put("addr", "공주");
		
		return map;
	}
	


}
