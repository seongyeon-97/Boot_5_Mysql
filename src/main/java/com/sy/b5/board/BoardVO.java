package com.sy.b5.board;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	private Integer num;
	private String title;
	private String contents;
	private String writer;
	private Integer hit;
	private Date regDate;
}
