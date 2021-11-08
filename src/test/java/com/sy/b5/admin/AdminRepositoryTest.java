package com.sy.b5.admin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sy.b5.member.MemberVO;

@SpringBootTest
class AdminRepositoryTest {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Test
	void getMemberListTest() throws Exception {
		List<MemberVO> ar = adminRepository.getMemberList();
		for(MemberVO memberVO:ar) {
			System.out.println(memberVO.getId());
			System.out.println(memberVO.getName());
			System.out.println(memberVO.getEmail());
			System.out.println(memberVO.getMemberFilesVO().getFileNum());
		}
	}

}
