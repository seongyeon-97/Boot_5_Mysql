package com.sy.b5.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sy.b5.board.BoardFileVO;
import com.sy.b5.util.FileManager;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private FileManager fileManager;

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

	public MemberVO getLogin(MemberVO memberVO) throws Exception {
		return memberRepository.getLogin(memberVO);

	}
}
