package spring.mvc.config.init;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spring.mvc.config.servlet.WebConfig;
import spring.mvc.config.session.SessionRedisConfig;

//Java 기반 Spring 구성을 사용하는 응용 프로그램에 권장됩니다.
@Order(1)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}

/*
// DispatcherServlet을 등록하고 초기화하는 Java 구성의 예입니다.  
public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletCxt) throws ServletException {
		
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		ac.register(WebConfig.class);
		ac.refresh();
		System.out.println("onStartUp");
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(ac);
		ServletRegistration.Dynamic registration = servletCxt.addServlet("dispatcher", dispatcherServlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/spring/mvc/java");
	}
}
*/

/*
// WebApplicationContext 계층을 사용한 구성 예제입니다.
public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return  new Class<?>[] { RootContext.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { AppContext.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/spring/mvc/java" };
	}
	
}
*/

/*
// web.xml 파일 없이 DispatcherServlet 등록
public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        appContext.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");

        ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet(appContext));
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
		
	}
}
*/

/*
// XML 기반 Spring 구성을 사용하는 경우 
// AbstractDispatcherServletInitializer는 Filter 인스턴스를 추가하고
// DispatcherServlet에 자동 매핑되도록하는 편리한 방법을 제공합니다.
public class MyWebApplicationInitializer extends AbstractDispatcherServletInitializer {

	@Override
	protected WebApplicationContext createRootApplicationContext() {
		return null;
	}
	
	@Override
	protected WebApplicationContext createServletApplicationContext() {
		XmlWebApplicationContext context = new XmlWebApplicationContext();
		context.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");
		return context;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] {
				(Filter) new HiddenHttpMethodFilter(), new CharacterEncodingFilter()
		};
	}
}
*/


