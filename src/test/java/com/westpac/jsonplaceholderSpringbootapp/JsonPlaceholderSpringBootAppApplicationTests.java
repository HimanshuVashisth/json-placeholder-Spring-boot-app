package com.westpac.jsonplaceholderSpringbootapp;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.westpac.jsonplaceholderSpringbootapp.model.PostModel;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JsonPlaceholderSpringBootAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JsonPlaceholderSpringBootAppApplicationTests {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testFetchPosts() {
		
	}

	private String composeURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
