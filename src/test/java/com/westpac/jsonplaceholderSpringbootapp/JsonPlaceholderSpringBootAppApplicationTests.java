package com.westpac.jsonplaceholderSpringbootapp;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.westpac.jsonplaceholderSpringbootapp.model.CommentModel;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class JsonPlaceholderSpringBootAppApplicationTests {
	
	private static final Logger log=LoggerFactory.getLogger(JsonPlaceholderSpringBootAppApplicationTests.class);

    @LocalServerPort
    int port;
    
    String response=null;

    @BeforeEach
    public void setUp() {
    	RestAssured.baseURI="http://localhost";
        RestAssured.port = port;
    }

    @Test
    public void testfetchAllPosts() throws InterruptedException {
        given().basePath("/posts").then().statusCode(200);
    }
    
    @Test
    public void fetchCommentsByPostId() throws  InterruptedException {    	
    	List<CommentModel> comments = new ArrayList<>();
    	
    	response = expect().statusCode(200).when().get("/posts/comments?postId=1").body().asString();
		log.info(response);
		
    	given().contentType(ContentType.JSON).when().body(comments).post("/posts/comments?postId=1").then().extract().response();
    	
    }

}
