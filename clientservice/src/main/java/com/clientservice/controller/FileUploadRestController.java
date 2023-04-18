package com.clientservice.controller;

import java.io.InputStream;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.clientservice.service.*;

@RestController
public class FileUploadRestController {

	@Autowired
	FileUploadService fileUploadService;


	private static final Logger logger = Logger.getLogger(FileUploadRestController.class.getName());

	@PostMapping("/upload")
	public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) throws Exception {

		if (file == null) {
			throw new RuntimeException("You must select the a file for uploading");
		}
		String  response = fileUploadService.uploadFile(file);
		String originalName = "success";




		// Do processing with uploaded file data in Service layer
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}