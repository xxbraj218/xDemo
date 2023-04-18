package com.clientservice.service;

import java.io.InputStream;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;


import com.clientservice.util.*;

@Service
public class FileUploadService {
	private static final Logger logger = Logger.getLogger(FileUploadService.class.getName());

	@Autowired
	FileUploadUtil fileUploadUtil;
	public String uploadFile(MultipartFile file) {
		String filecode = null;
		try {
			InputStream inputStream = file.getInputStream();
			String originalName = file.getOriginalFilename();
			String name = file.getName();
			String contentType = file.getContentType();
			long size = file.getSize();

			logger.info("inputStream: " + inputStream);
			logger.info("originalName: " + originalName);
			logger.info("name: " + name);
			logger.info("contentType: " + contentType);
			logger.info("size: " + size);
			filecode = fileUploadUtil.saveFile("NewUpload", file);

		} catch (Exception e) {
			return "Exception:FAIL";
		}
		if (null != filecode) {
			return "success:" + filecode;
		} else {
			return "failure:FAIL";
		}

	}
}