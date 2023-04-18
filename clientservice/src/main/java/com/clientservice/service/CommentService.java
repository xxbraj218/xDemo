package com.clientservice.service;

import java.io.InputStream;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.clientservice.request.CommentRequest;
import com.clientservice.util.commonutil.*;

@Service
public class CommentService {
	private static final Logger logger = Logger.getLogger(CommentService.class.getName());
	@Value("${comment.url}")
	String commentUrl;
	@Autowired
	WebClientConfiguration webClientConfiguration;

	public String postComment(CommentRequest commentRequest, String doucumentId) {
		commentRequest.setDocumentId(doucumentId);
		CommentRequest result = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			result = restTemplate.postForObject(commentUrl, commentRequest, CommentRequest.class);
		} catch (Exception e) {
			return "Exception:FAIL";
		}
		if (null != result) {
			return "success:";
		} else {
			return "FAIL";
		}

	}

	/**********
	 *
	 *
	 * @param commentRequest
	 * @param doucumentId
	 * @return
	 */

	public String postCommentWithTimeout(CommentRequest commentRequest, String doucumentId) {
		commentRequest.setDocumentId(doucumentId);
		CommentRequest result = null;
		try {
			RestTemplate restTemplate = webClientConfiguration.getClientwithTimeout();

		} catch (Exception e) {
			return "Exception:FAIL";
		}
		if (null != result) {
			return "success:";
		} else {
			return "FAIL";
		}

	}


}