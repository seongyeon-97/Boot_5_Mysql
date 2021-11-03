package com.sy.b5.board;

import java.util.List;

import com.sy.b5.util.Pager;

public interface BoardMapper {
	//Insert 글쓰기
	public int setInsert(BoardVO boardVO) throws Exception;
	
	//Update 글수정
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	//Update 조회수
	public int setHitUpdate(BoardVO boardVO) throws Exception;
	
	//Delete 글삭제
	public int setDelete(BoardVO boardVO) throws Exception;
	
	//Select 글 1개 조회
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception;
	
	//Select 글 List 조회
	public List<BoardVO> getSelectList(Pager pager) throws Exception;
}
