package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class PrototypeTest {
	@Test
	void prototypeBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
		System.out.println("find prototypeBean1");
		PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
		System.out.println("find prototypeBean2");
		PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
		System.out.println("prototypeBean1 = " + prototypeBean1);
		System.out.println("prototypeBean2 = " + prototypeBean2);
		assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

		//종료 메소드 필요 시, 직접 호출
		prototypeBean1.destroy();
		prototypeBean2.destroy();
		ac.close();
	}

	@Scope("prototype")
//	@Component가 없어도 동작하는 이유? 해당 클래스를 ACAC의 매개변수로 입력 시, 컴포넌트 스캔의 대상처럼 동작한다
	static class PrototypeBean {

		@PostConstruct
		public void init() {
			System.out.println("PrototypeBean.init");
		}

		@PreDestroy
		public void destroy() {
			System.out.println("PrototypeBean.destroy");
		}
	}
}
