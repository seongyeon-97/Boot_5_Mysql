package com.sy.b5.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MemberRepositoryTest {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	void getLoginTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("user");
		memberVO.setPw("user111");
		memberVO = memberRepository.getLogin(memberVO);
		
		assertNotNull(memberVO);
	}
	
	//@Test
	void setFileInsertTest() throws Exception{
		MemberFilesVO memberFilesVO = new MemberFilesVO();		
		memberFilesVO.setMember_id("user");
		memberFilesVO.setOriName("userOriName");
		memberFilesVO.setFileName("userFile");
		int result = memberRepository.setFileInsert(memberFilesVO);
		
		assertEquals(1, result);
	}
	
	
	//@Test
	void setInsertTest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("user");
		memberVO.setPw("user");
		memberVO.setName("user");
		memberVO.setEmail("user@naver.com");
		int result = memberRepository.setInsert(memberVO);
		
		assertEquals(1, result);
	}

}
