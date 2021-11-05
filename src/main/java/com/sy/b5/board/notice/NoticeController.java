package com.sy.b5.board.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sy.b5.board.BoardVO;
import com.sy.b5.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	   public String getBoard() {
	      return "notice";
	   }
	
	// notice/insert -> 입력폼 제공, 파리미터 x
	// 서버 내부에서 jsp로 이동 -> forword
	// 응답으로 html이 아닌 url 주소를 리턴하는 것 -> redirect -> 웹브라우저는 받은 url 주소로 다시 요청을 보냄 
	@GetMapping("insert")
	public String setInsert() throws Exception {
		return "board/insert";
	}

	// notice/insert -> DB 처리, 파리미터 o(title, contents, writer)
	@PostMapping("insert")
	public String setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {		
			
		
		int result = noticeService.setInsert(boardVO, files); 
		return "redirect: ./selectList";
		
		/*
		 * if (result > 0) { mv.setViewName("reidrect: ../"); } else {
		 * 
		 * }
		 */
	}

	// notice/update -> 입력폼 제공, 파라미터 o(num)
	@GetMapping("update")
	public String setUpdate(BoardVO boardVO, Model model) throws Exception {		
		boardVO = noticeService.getSelectOne(boardVO);
		model.addAttribute("boardVO", boardVO);
		return "board/update";
	}

	// notice/update -> DB 처리, 파리미터 o(title, contents)
	@PostMapping("update")
	public String setUpdate(BoardVO boardVO) throws Exception{
		int result = noticeService.setUpdate(boardVO);
		return "redirect: ./selectOne?num="+boardVO.getNum();
	}
	
	
	// notice/delete -> 파라미터 num
	@GetMapping("delete")
	public String setDelete(BoardVO boardVO) throws Exception{
		int result = noticeService.setDelete(boardVO);
		return "redirect: ./selectList";
	}
	
	
	// SelectOne
	@GetMapping("selectOne")
	public ModelAndView getSelectOne(BoardVO boardVO) throws Exception {

		// HttpServletRequest request를 파라미터로 선언하여 그 안에 있는 파리미터 값을 가져온다.
		// String num = request.getParameter("num");
		// int n = Integer.parseInt(num);
		// BoardVO boardVO = new BoardVO();
		// boardVO.setNum(n);

		// 파라미터 값을 int num으로 받을때
		// BoardVO boardVO = new BoardVO();
		// boardVO.setNum(num);
		
		ModelAndView mv = new ModelAndView();
		boardVO = noticeService.getSelectOne(boardVO);
		mv.setViewName("board/select");
		mv.addObject("boardVO", boardVO);
		return mv;

	}

	// SelectList
	@GetMapping("selectList")
	public ModelAndView getSelectList(ModelAndView mv, Pager pager) throws Exception {		
		// kind : column
		// search : 검색어 
		
		List<BoardVO> ar = noticeService.getSelectList(pager);
		mv.setViewName("board/list");
		mv.addObject("boardList", ar);
		mv.addObject("pager", pager);
		return mv;
	}

}
