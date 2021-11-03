package com.sy.b5.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.b5.board.BoardService;
import com.sy.b5.board.BoardVO;
import com.sy.b5.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	//DI , IOC - 스프링의 가장 핵심 단어, 설계도를 제공하면 스프링 컨테이너가 생성
	
	@Autowired //의존성 주입
	private NoticeMapper noticeMapper;
	
	@Override
	public int setInsert(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.setInsert(boardVO);
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.setUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.setDelete(boardVO);
	}

	@Override
	public BoardVO getSelectOne(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.getSelectOne(boardVO);
	}

	@Override
	public List<BoardVO> getSelectList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRow(); // 페이징 처리를 위해
		
		// 1. 총 글의 갯수를 db에서 조회
		Long totalCount = noticeMapper.getTotalCount(pager);
		System.out.println("총 글의 갯수 : " + totalCount);
		
		// 2. 나머지 pager 기능 구현
		pager.makeNum(totalCount);
		return noticeMapper.getSelectList(pager);
	}

}
