package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
	@Test
	public void lifeCycleTest() {
//		상속 관계
//		ApplicationContext -> ConfigurableApplicationContext -> AnnotationConfigApplicationContext
		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
		NetworkClient client = ac.getBean(NetworkClient.class);
		ac.close();
	}

	@Configuration
	static class LifeCycleConfig {
		@Bean
		public NetworkClient networkClient() {
			//객체 생성
			NetworkClient networkClient = new NetworkClient();
			//Setter
			networkClient.setUrl("http://hello-spring.dev");
			return networkClient;
		}
	}
}