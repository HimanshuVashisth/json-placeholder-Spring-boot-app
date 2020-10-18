package com.westpac.jsonplaceholderSpringbootapp.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.westpac.jsonplaceholderSpringbootapp.exception.RestApiException;
import com.westpac.jsonplaceholderSpringbootapp.exception.ThirdPartyException;
import com.westpac.jsonplaceholderSpringbootapp.model.CommentModel;
import com.westpac.jsonplaceholderSpringbootapp.model.PostModel;
import com.westpac.jsonplaceholderSpringbootapp.service.impl.PostService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:3000",maxAge = 3600)
@RestController
@RequestMapping("/posts")
public class PostsController {
	
	private final Logger log = LoggerFactory.getLogger(PostsController.class);
		
	@Autowired
	private PostService postService;
	
    @ApiOperation(value = "JSON PLACEHOLDER GET POSTS Service")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ArrayList<PostModel>> fetchPosts() throws ThirdPartyException, IOException, RestApiException {
    	log.info("Fetch all Posts Service");    	
    	ArrayList<PostModel> posts = postService.getPosts();
    	
        if (posts != null) {        	
            return ResponseEntity.ok(posts);
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    
    @ApiOperation(value = "JSON PLACEHOLDER GET Comments for a post Service")
    @RequestMapping(value = "/comments",method = RequestMethod.GET)
    public ResponseEntity<ArrayList<CommentModel>> fetchCommentsByPostId(@RequestParam(value="postId") int postId) throws ThirdPartyException, IOException, RestApiException {    
    	log.info("Fetch Comments by postId Service");    	
    	ArrayList<CommentModel> comments = postService.getCommentsByPostId(postId);    	
    	
        if (comments != null) {        	
            return ResponseEntity.ok(comments);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

}
