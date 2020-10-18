package com.westpac.jsonplaceholderSpringbootapp.service.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.westpac.jsonplaceholderSpringbootapp.config.ConfigProperties;
import com.westpac.jsonplaceholderSpringbootapp.model.CommentModel;
import com.westpac.jsonplaceholderSpringbootapp.model.PostModel;
import com.westpac.jsonplaceholderSpringbootapp.service.IPostsService;

@Service
public class PostService implements IPostsService {
	
	private static final Logger log = LoggerFactory.getLogger(PostService.class);
	
    @Autowired
    private RestTemplate restTemplate;
    
	@Autowired
    private Environment environment;

	@Override
	public ArrayList<PostModel> getPosts() {
		String jsonPlaceholderTypiCodePostsApiUrl = environment.getProperty(ConfigProperties.JSON_PLACEHOLDER_TYPICODE_URL_POST);
		
		PostModel[] posts = restTemplate.getForObject(jsonPlaceholderTypiCodePostsApiUrl, PostModel[].class);
		ArrayList<PostModel> postsList = new ArrayList<>(Arrays.asList(posts));
		return postsList;
	}

	public ArrayList<CommentModel> getCommentsByPostId(int postId) {
		String jsonPlaceholderTypiCodeCommentsApiUrl = environment.getProperty(ConfigProperties.JSON_PLACEHOLDER_TYPICODE_URL_COMMENTS_FOR_POST);
		
		CommentModel[] comments = restTemplate.getForObject(jsonPlaceholderTypiCodeCommentsApiUrl + postId, CommentModel[].class);
		ArrayList<CommentModel> coomentsList = new ArrayList<>(Arrays.asList(comments));
				
		return coomentsList;
	}

}
