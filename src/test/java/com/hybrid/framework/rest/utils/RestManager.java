package com.hybrid.framework.rest.utils;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class RestManager extends RestCore{

	/**
	 * @description Accepts Request without Authentication
	 * @param contentType
	 */
	public RestManager(ContentType contentType) {
		super(contentType);
	}
	
	/**
	 * @description Accepts Request with Authentication
	 * @param contentType
	 * @param username
	 * @param password
	 */
	public RestManager(ContentType contentType, String username, String password) {
		super(contentType, username, password);
	}
	
	/**
	 * @description Sends request to the Server without Headers 
	 * @param baserUri
	 * @param method
	 * @param resourceUri
	 * @param requestParameter
	 * @param requestBody
	 * @return
	 */
	public Response sendRequest(String baserUri, Method method, String resourceUri, String requestParameter, String requestBody) {
		Response response;
		requestParameter = requestParameter==null?"":requestParameter;
		if(method == Method.GET) {
			response = getResponseProcessor().setResponseForLastThread(createRequest().baseUri(baserUri).request(method, resourceUri + requestParameter));
		} else {
			response = getResponseProcessor().setResponseForLastThread(createRequest().baseUri(baserUri).body(requestBody).request(method, resourceUri + requestParameter));
		}
		return response;
	}
	
	/**
	 * @description Sends request to the Server with Headers
	 * @param headers
	 * @param baserUri
	 * @param method
	 * @param resourceUri
	 * @param requestParameter
	 * @param requestBody
	 * @return
	 */
	public Response sendRequest(Headers headers, String baserUri, Method method, String resourceUri, String requestParameter, String requestBody) {
		Response response;
		requestParameter = requestParameter==null?"":requestParameter;
		if(method == Method.GET) {
			response = getResponseProcessor().setResponseForLastThread(createRequest().baseUri(baserUri).headers(headers).request(method, resourceUri + requestParameter));
		} else {
			response = getResponseProcessor().setResponseForLastThread(createRequest().baseUri(baserUri).headers(headers).body(requestBody).request(method, resourceUri + requestParameter));
		}
		return response;
	}

}
