package spring.mvc.web.login.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Order(1)
public class LoginController {
	
	private static final Logger logger = LogManager.getLogger(LoginController.class);
	
	
	@Bean(initMethod="init", destroyMethod="cleanup")
	@Order(2)
	public Bar bar() {
		return new Bar();
	}
	
	@Bean(initMethod="init", destroyMethod="cleanup")
	@Order(100000)
    public Foo foo() {
        return new Foo();
    }
	
	@PreDestroy
	public void beanPre() {
		logger.info("Hello, world!");
		logger.debug("sdfsdf");
		System.out.println("LoginController @@PreDestroy");
	}
	
	@PostConstruct
	public void beanPost() {
		logger.info("Hello, world!");
		logger.debug("sdfsdf");
		System.out.println("LoginController @PostConstruct");
	}
	
	@RequestMapping("/web")
	public String index() {
		return "index";
	}
	
	public class Bar {
		
		public void init() {
			System.out.println("Bar init");
		}
		
		public void cleanup() {
			System.out.println("Bar cleanup");
			
		}
	}
	
	public class Foo {
		public void init() {
			System.out.println("Foo init");
		}
		public void cleanup() {
			System.out.println("Foo cleanup");
		}
	}

}
