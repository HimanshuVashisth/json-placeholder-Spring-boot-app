package com.westpac.jsonplaceholderSpringbootapp.service;

import java.util.ArrayList;

import com.westpac.jsonplaceholderSpringbootapp.model.CommentModel;
import com.westpac.jsonplaceholderSpringbootapp.model.PostModel;

public interface IPostsService {

	public ArrayList<PostModel> getPosts();
	
	public ArrayList<CommentModel> getCommentsByPostId(int postId);
	
}
