package com.hybrid.framework.rest.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;

public class RequestProcessor {

	private final ThreadLocal<RequestSpecification> specification = new ThreadLocal<>();
	private final RequestSpecification requestSpecification;
	
	protected RequestProcessor(ContentType contentType) {
		this.requestSpecification = RestAssured.given()
				.accept(contentType).contentType(contentType);
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.defaultParser = Parser.TEXT;
		this.specification.set(requestSpecification);
	}
	
	protected RequestSpecification getRequestSpecificationForLastThread() {
		return specification.get();
	}
}
