package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
	@Test
	void AutowiredOption() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

	}

	static class TestBean {
		//의존관계가 없을 때, 메소드 호출 X
		@Autowired(required = false)
		public void setNoBean1(Member noBean1) {
			System.out.println("noBean1 = " + noBean1);
		}

		//호출은 되나 주입 대상이 없으면 null이 들어옴
		@Autowired
		public void setNoBean2(@Nullable Member noBean2) {
			System.out.println("noBean2 = " + noBean2);
		}

		//호출은 되나 주입 대상이 없으면 Optional.empty가 들어옴
		@Autowired
		public void setNoBean3(Optional<Member> noBean3) {
			System.out.println("noBean3 = " + noBean3);
		}
	}
}
