package com.sy.b5.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.sy.b5.board.BoardMapper;

@Mapper
public interface QnaMapper extends BoardMapper{
	
	public int setReplyInsert(QnaVO qnaVO) throws Exception;
}
