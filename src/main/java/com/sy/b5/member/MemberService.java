package com.sy.b5.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.sy.b5.board.BoardFileVO;
import com.sy.b5.util.FileManager;

@Service
public class MemberService implements UserDetailsService{
	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private FileManager fileManager;
	
	// 검증하는 메서드 선언
	public boolean memberError(MemberVO memberVO, BindingResult bindingResult) throws Exception{
		boolean check = false; // false이면 검증 성공, true면 검증 실패(에러, 위반 발생)
		
		// 1. Annotation 검증
		check = bindingResult.hasErrors();
		
		// 2. pw가 일치하는지 검증
		if(memberVO.getPw().equals(memberVO.getPwCheck())) {
			bindingResult.rejectValue("pwCheck", "pwCheck");
			check = true;
		}
		
		memberVO = memberRepository.getSelect(memberVO);
		
		if(memberVO !=null) {
			bindingResult.rejectValue("id", "member.id.equals");
			check = true;
		}
		
		return check;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Load User By UserName");
		System.out.println(username);
		MemberVO memberVO = null;
		try {
			memberVO = memberRepository.getLogin(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Spring security UserDetails 리턴 받아서 비번을 비교 진행
		return memberVO;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int setInsert(MemberVO memberVO, MultipartFile files) throws Exception {

		int result = memberRepository.setInsert(memberVO);

		if (!files.isEmpty()) {
			String fileName = fileManager.getUseServletContext("upload/member", files);
			MemberFilesVO memberFilesVO = new MemberFilesVO();
			memberFilesVO.setMember_id(memberVO.getId());			
			memberFilesVO.setFileName(fileName);
			memberFilesVO.setOriName(files.getOriginalFilename());
			result = memberRepository.setFileInsert(memberFilesVO);
			
			if(result == 0) {
				throw new Exception();
			}
			
		}
		return result;

	}

	/*
	 * public MemberVO getLogin(MemberVO memberVO) throws Exception { return
	 * memberRepository.getLogin(memberVO);
	 * 
	 * }
	 */
}
