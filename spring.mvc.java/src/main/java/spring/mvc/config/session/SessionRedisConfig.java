package spring.mvc.config.session;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/*
 *  @EnableRedisHttpSession
 *  Filter를 구현하는 springSessionRepositoryFilter라는 이름으로 Spring Bean을 생성한다.
 *  Filter는 HttpSession 구현을 Spring Session에 의해 대체되도록 하는 역할을합니다.
 *  이 경우 Spring Session은 Redis에 의해 지원됩니다.
 */
@EnableRedisHttpSession 
public class SessionRedisConfig {
	@Bean
	public LettuceConnectionFactory connectionFactory() {
		return new LettuceConnectionFactory(); 
		// 우리는 Redis Server에 Spring Session을 연결하는 RedisConnectionFactory을 만들 수 있습니다.
	}
}