package com.sy.b5.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	@Autowired
	private ServletContext servletContext;

	@Autowired
	private ResourceLoader resourceLoader;

	// 1. ClassPathResources
	public String getUseClassPathResource(String filePath, MultipartFile multipartFile) throws Exception{
		String path = "static";
		
		ClassPathResource classPathResource = new ClassPathResource(path);
		
		File file = new File(classPathResource.getFile(), filePath);
		if (!file.exists()) {
			file.mkdirs();
		}

		// 경로에 파일을 저장하는 단계

		String fileName = "";
		fileName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();

		file = new File(file, fileName);
		multipartFile.transferTo(file);

		return fileName;
	}
	
	// 2. ResourceLoader를 사용하는 방법
	public String getUseResourceLoder(String filePath, MultipartFile multipartFile) throws Exception {
		String path = "classpath:/static/";
		File file = new File(resourceLoader.getResource(path).getFile(), filePath);

		if (!file.exists()) {
			file.mkdirs();
		}

		// 경로에 파일을 저장하는 단계

		String fileName = "";
		fileName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();

		file = new File(file, fileName);
		multipartFile.transferTo(file);

		return fileName;
	}

	// 3. ServletContext 사용하여 실제 경로 받아오는 방법
	public String getUseServletContext(String filePath, MultipartFile multipartFile) throws Exception {
		filePath = servletContext.getRealPath(filePath);

		File file = new File(filePath);

		if (!file.exists()) {
			file.mkdirs();
		}

		// 경로에 파일을 저장하는 단계

		// 1. 유니크한 이름 생성
		String fileName = "";
		fileName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();

		file = new File(file, fileName);
		multipartFile.transferTo(file);

		return fileName;

	}

}
