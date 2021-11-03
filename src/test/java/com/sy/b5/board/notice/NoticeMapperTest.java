package com.sy.b5.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sy.b5.board.BoardVO;

@SpringBootTest
class NoticeMapperTest {

	@Autowired
	private NoticeMapper noticeMapper;

	@Test
	void setInserttest() throws Exception {
		for (int i = 0; i < 100; i++) {
			BoardVO boardVO = new BoardVO();
			boardVO.setTitle("title" + i);
			boardVO.setWriter("writer" + i);
			boardVO.setContents("contents" + i);
			int a = noticeMapper.setInsert(boardVO);
			if(i%10==0) {
				Thread.sleep(500);
			}
		}
		System.out.println("finish");
//		assertNotEquals(0, a);
	}

	// @Test
	void setUpdatetest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("a1111");
		boardVO.setWriter("writer1111");
		boardVO.setContents("aaaaa111111");
		boardVO.setNum(4);
		int a = noticeMapper.setUpdate(boardVO);
		assertNotEquals(0, a);
	}

	// @Test
	void setHitUpdatetest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(4);

		int a = noticeMapper.setHitUpdate(boardVO);
		assertNotEquals(0, a);
	}

	// @Test
	void setDeletetest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(4);

		int a = noticeMapper.setDelete(boardVO);
		assertNotEquals(0, a);
	}

	// @Test
	void getSelectOnetest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(3);

		boardVO = noticeMapper.getSelectOne(boardVO);
		assertNotNull(boardVO);
	}

	// @Test
//	void getSelectListtest() throws Exception {
//		List<BoardVO> ar = noticeMapper.getSelectList();
//		assertNotEquals(0, ar.size());
//	}

}
