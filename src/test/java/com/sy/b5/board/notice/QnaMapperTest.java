package com.sy.b5.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sy.b5.board.BoardVO;
import com.sy.b5.board.qna.QnaMapper;

@SpringBootTest
class QnaMapperTest {

	@Autowired
	private QnaMapper qnaMapper;

	@Test
	void setInserttest() throws Exception {
		for (int i = 0; i < 100; i++) {
			BoardVO boardVO = new BoardVO();
			boardVO.setTitle("title" + i);
			boardVO.setWriter("writer" + i);
			boardVO.setContents("contents" + i);
			int a = qnaMapper.setInsert(boardVO);
			if(i%10==0) {
				Thread.sleep(500);
			}
		}
		System.out.println("finish");
//		assertNotEquals(0, a);
	}
}
