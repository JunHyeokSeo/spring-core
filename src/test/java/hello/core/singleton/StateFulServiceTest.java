package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {

	@Test
	void statefulServiceSingleton() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

		StateFulService stateFulService1 = ac.getBean(StateFulService.class);
		StateFulService stateFulService2 = ac.getBean(StateFulService.class);

		stateFulService1.order("userA", 10000);
		stateFulService1.order("userB", 20000);

		Assertions.assertThat(stateFulService1.getPrice()).isEqualTo(20000);
	}

	static class TestConfig {
		@Bean
		public StateFulService stateFulService() {
			return new StateFulService();
		}
	}
}