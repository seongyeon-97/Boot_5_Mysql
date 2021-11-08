package com.sy.b5.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Repository // 밑의 해당 클래스가 dao 역할을 할껀데 new code를 실행해 객체를 만드는 역할
@Mapper // 선언함으로써 interface를 알아서 작동을 시켜줌
public interface MemberRepository {

	// 회원가입 insert
	public int setInsert(MemberVO memberVO) throws Exception;
	
	// 회원파일 insert
	public int setFileInsert(MemberFilesVO memberFilesVO) throws Exception;
	
	// 로그인
	public MemberVO getLogin(MemberVO memberVO) throws Exception;
}
