package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {
	//Spring Bean을 등록하는 방법 크게 두가지
	//1. BeanFactory를 통해 우회하여 등록 - Java 코드를 통한 등록 (FactoryBean 정보 O, 실제 클래스 파일 위치정보 X)
	//2. 직접 Bean을 등록 - XML을 통한 등록 (FactoryBean 정보 X, 실제 클래스 파일 위치정보 O)


	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//	GenericApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

	@Test
	@DisplayName("빈 설정 메타정보 확인")
	void findApplicationBean() {
		String[] names = ac.getBeanDefinitionNames();
		for (String name : names) {
			BeanDefinition definition = ac.getBeanDefinition(name);
			if (definition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				System.out.println("[name] = " + name + " [definition] = " + definition);
			}
		}
	}
}

