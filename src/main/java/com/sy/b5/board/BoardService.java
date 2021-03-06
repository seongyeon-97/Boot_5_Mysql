package com.sy.b5.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sy.b5.util.Pager;

public interface BoardService {
	// Insert 글쓰기
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception;

	// Update 글수정
	public int setUpdate(BoardVO boardVO) throws Exception;	

	// Delete 글삭제
	public int setDelete(BoardVO boardVO) throws Exception;

	// Select 글 1개 조회
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception;

	// Select 글 List 조회
	public List<BoardVO> getSelectList(Pager pager) throws Exception;
}
