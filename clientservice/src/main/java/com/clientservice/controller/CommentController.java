package com.clientservice.controller;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.clientservice.request.CommentRequest;
import com.clientservice.service.CommentService;

@RestController
public class CommentController
{

    @Autowired
    CommentService commentService;


    private static final Logger logger = Logger.getLogger(CommentController.class.getName());

    @PostMapping("/api/posts/{documentId}/comment")
    public ResponseEntity<CommentRequest> addComment(@RequestBody CommentRequest commentRequest,
                                              @PathVariable(name = "documentId") String documentId) {
       String resStatus = commentService.postComment(commentRequest, documentId);

        if(null == resStatus || resStatus.toUpperCase().contains("FAIL")) {
            return new ResponseEntity<>(commentRequest, HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(commentRequest, HttpStatus.ACCEPTED);
    }
}