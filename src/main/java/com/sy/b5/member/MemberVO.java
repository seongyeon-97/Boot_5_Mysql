package com.sy.b5.member;


import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class MemberVO {
	
	@NotBlank
	private String id;
	@Size(min = 6, max = 12)
	private String pw;
	private String pwCheck;
	@NotBlank
	private String name;
	@NotBlank
	@Email	
	private String email;
	@NotNull
	@Range(min = 0, max = 150)
	private Integer age; // 나이
	@Past
	private Date birth; // 생년월일 
	private String role;
	private MemberFilesVO memberFilesVO;
}
