package com.sy.b5.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sy.b5.board.BoardFileVO;
import com.sy.b5.util.FileManager;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private FileManager fileManager;

	public int setInsert(MemberVO memberVO, MultipartFile[] files) throws Exception {
		int result = memberRepository.setInsert(memberVO);

		for (MultipartFile multipartFile : files) {

			// multipartFile.isEmpty()
			if (multipartFile.getSize() == 0L) {
				continue;
			}

			MemberFilesVO memberFilesVO = new MemberFilesVO();

			memberFilesVO.setMember_id(memberVO.getId());

			String fileName = fileManager.getUseServletContext("/upload/member/", multipartFile);
			memberFilesVO.setFileName(fileName);
			memberFilesVO.setOriName(multipartFile.getOriginalFilename());
			result = memberRepository.setFileInsert(memberFilesVO);
		}

		return result;
	}
}
