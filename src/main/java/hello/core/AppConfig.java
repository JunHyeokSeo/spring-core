package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration : Application 설정 정보
@Configuration
public class AppConfig {

	//역할과 구현이 드러나도록 리팩토링
	/*
	public MemberService memberService() {
		return new MemberServiceImpl(new MemoryMemberRepository());
	}

	public OrderServiceImpl orderService() {
		return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
	}
	*/

	//리팩토링 완료
	//@Bean : Spring Container에 자동 등록
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(getMemberRepository());
	}
	
	@Bean
	public OrderServiceImpl orderService() {
		return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
	}

	@Bean
	public MemberRepository getMemberRepository() {
		return new MemoryMemberRepository();
	}

	@Bean
	public DiscountPolicy getDiscountPolicy() {
//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
}
