package com.sy.b5.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sy.b5.board.BoardFileVO;
import com.sy.b5.board.BoardService;
import com.sy.b5.board.BoardVO;
import com.sy.b5.util.FileManager;
import com.sy.b5.util.Pager;

@Service
public class NoticeService implements BoardService {

	// DI , IOC - 스프링의 가장 핵심 단어, 설계도를 제공하면 스프링 컨테이너가 생성

	@Autowired // 의존성 주입
	private NoticeMapper noticeMapper;

	@Autowired
	private FileManager fileManager;

	@Override
	public int setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		// 1.
		//fileManager.getUseClassPathResource("upload/notice/", files[0]);		
		// 2. 
		//fileManager.getUseResourceLoder("upload/notice/", files[0]);	
		// 3. 
		//fileManager.getUseServletContext("/upload/notice/", files[0]);
		
		int result = noticeMapper.setInsert(boardVO);
		
		for(MultipartFile multipartFile:files) {
			
			// multipartFile.isEmpty()
			if(multipartFile.getSize() ==0L) {
				continue;
			}
			
			BoardFileVO boardFileVO = new BoardFileVO();
			
			boardFileVO.setNum(boardVO.getNum());
			
			String fileName = fileManager.getUseServletContext("/upload/notice/", multipartFile);
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriName(multipartFile.getOriginalFilename());
			result = noticeMapper.setFileInsert(boardFileVO);
		}
		
		return result;
		
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
