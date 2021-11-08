package com.sy.b5.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sy.b5.member.MemberVO;

@Controller
@RequestMapping("/admin/**")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("memberList")
	public ModelAndView getMemberList() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<MemberVO> ar= adminService.getMemberList();
		mv.setViewName("admin/memberList");
		mv.addObject("memberList", ar);
		return mv;
		
	}
}
