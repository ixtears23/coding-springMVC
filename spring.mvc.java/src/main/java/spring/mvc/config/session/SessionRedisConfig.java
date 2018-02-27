package spring.mvc.config.session;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/*
 *  @EnableRedisHttpSession
 *  Filter�� �����ϴ� springSessionRepositoryFilter��� �̸����� Spring Bean�� �����Ѵ�.
 *  Filter�� HttpSession ������ Spring Session�� ���� ��ü�ǵ��� �ϴ� �������մϴ�.
 *  �� ��� Spring Session�� Redis�� ���� �����˴ϴ�.
 */
@EnableRedisHttpSession 
public class SessionRedisConfig {
	@Bean
	public LettuceConnectionFactory connectionFactory() {
		return new LettuceConnectionFactory(); 
		// �츮�� Redis Server�� Spring Session�� �����ϴ� RedisConnectionFactory�� ���� �� �ֽ��ϴ�.
	}
}