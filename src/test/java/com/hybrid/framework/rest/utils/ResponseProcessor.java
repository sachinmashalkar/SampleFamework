package com.hybrid.framework.rest.utils;

import io.restassured.response.Response;

public class ResponseProcessor {

	private final ThreadLocal<Response> response = new ThreadLocal<>();
	
	protected Response lastResponseForThread() {
		return response.get();
	}
	
	protected Response setResponseForLastThread(Response response) {
		this.response.set(response);
		return response;
	}
}
