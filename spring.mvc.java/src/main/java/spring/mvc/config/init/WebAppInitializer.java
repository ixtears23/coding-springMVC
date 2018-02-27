package spring.mvc.config.init;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spring.mvc.config.servlet.WebConfig;
import spring.mvc.config.session.SessionRedisConfig;

//Java ��� Spring ������ ����ϴ� ���� ���α׷��� ����˴ϴ�.
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
// DispatcherServlet�� ����ϰ� �ʱ�ȭ�ϴ� Java ������ ���Դϴ�.  
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
// WebApplicationContext ������ ����� ���� �����Դϴ�.
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
// web.xml ���� ���� DispatcherServlet ���
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
// XML ��� Spring ������ ����ϴ� ��� 
// AbstractDispatcherServletInitializer�� Filter �ν��Ͻ��� �߰��ϰ�
// DispatcherServlet�� �ڵ� ���εǵ����ϴ� ���� ����� �����մϴ�.
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


