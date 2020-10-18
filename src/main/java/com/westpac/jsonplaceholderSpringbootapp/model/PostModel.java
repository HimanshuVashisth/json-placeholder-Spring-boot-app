package com.westpac.jsonplaceholderSpringbootapp.model;

import java.io.Serializable;

public class PostModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4258182883088945456L;

	private String userId;
	
	private int id;
	
	private String title;
	
	private String body;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
}
