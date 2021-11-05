package com.sy.b5.board;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {
	private Integer num;
	private String title;
	private String contents;
	private String writer;
	private Integer hit;
	private Date regDate;
	
	// file 관련
	private List<BoardFileVO> fileList;
}
