package com.sy.b5.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sy.b5.member.MemberVO;

@Mapper
public interface AdminRepository {
	public List<MemberVO> getMemberList() throws Exception;
}
