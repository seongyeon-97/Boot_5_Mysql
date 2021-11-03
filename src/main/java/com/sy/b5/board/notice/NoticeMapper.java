package com.sy.b5.board.notice;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sy.b5.board.BoardMapper;

//@Repository
@Mapper //객체 생성을 위해 선언
public interface NoticeMapper extends BoardMapper{
	
}
