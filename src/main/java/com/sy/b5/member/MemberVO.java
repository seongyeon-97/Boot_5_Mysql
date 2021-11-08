package com.sy.b5.member;

import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private String role;
	private MemberFilesVO memberFilesVO;
}
