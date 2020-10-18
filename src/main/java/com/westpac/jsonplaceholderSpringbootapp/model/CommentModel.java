package com.westpac.jsonplaceholderSpringbootapp.model;

import java.io.Serializable;

public class CommentModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2907739375459468050L;

	private int postId;
	
	private int id;
	
	private String name;
	
	private String email;
	
	private String body;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
}
