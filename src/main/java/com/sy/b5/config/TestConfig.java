package com.sy.b5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sy.b5.test.Test1;
import com.sy.b5.test.child1;
import com.sy.b5.test.child2;

@Configuration // xml 파일 역할, 객체를 정의하는 class를 의미
public class TestConfig {
	
	// 객체를 생성하는 메서드 선언
	@Bean // 객체를 생성시켜주는 bean 태그 = xml의 <bean> 역할
	public Test1 getTest1() {
		Test1 test1 = new Test1();
		return test1;
	}
	
	@Bean("child1")
	public child1 getChild1() {
		return new child1();
	}
	
	@Bean("child2")
	public child2 getChild2() {
		return new child2();
	}
}
