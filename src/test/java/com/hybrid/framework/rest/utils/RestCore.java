package com.hybrid.framework.rest.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestCore {

	private String username;
	private String password;
	
	private final RequestProcessor requestProcessor;
	private final RequestSpecification requestSpecification;
	private final ResponseProcessor responseProcessor;
	
	protected RestCore(ContentType contentType) {
		this.requestProcessor = new RequestProcessor(contentType);
		this.requestSpecification = requestProcessor.getRequestSpecificationForLastThread();
		responseProcessor = new ResponseProcessor();
	}
	
	protected RestCore(ContentType contentType, String username, String password) {
		this.requestProcessor = new RequestProcessor(contentType);
		this.requestSpecification = requestProcessor.getRequestSpecificationForLastThread();
		responseProcessor = new ResponseProcessor();
		this.username = username;
		this.password = password;
	}

	protected RequestSpecification createRequest() {
		return (username==null && password==null)?RestAssured.given(requestSpecification).auth().none():RestAssured.given(requestSpecification).auth().basic(username, password);
	}
	
	protected ResponseProcessor getResponseProcessor() {
		return responseProcessor;
	}
}
