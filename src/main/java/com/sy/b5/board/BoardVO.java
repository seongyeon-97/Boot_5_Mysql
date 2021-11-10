package com.sy.b5.board;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class BoardVO {
	private Integer num;
	@NotBlank
	private String title;
	@Length(min = 6, max = 20)
	private String contents;
	@Size(min = 4, max = 10)
	private String writer;
	private Integer hit;
	private Date regDate;
	
	// file 관련
	private List<BoardFileVO> fileList;
}
