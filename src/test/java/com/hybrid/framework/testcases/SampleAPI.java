package com.hybrid.framework.testcases;

import com.aventstack.extentreports.Status;
import com.hybrid.framework.core.util.ExtentReportManager;
import com.hybrid.framework.objects.PetDetailsObject;
import com.hybrid.framework.rest.utils.RestManager;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class SampleAPI {

	public static void main(String[] args) {
		ExtentReportManager.initExtentReport();
		ExtentReportManager.addSystemInfo();
		ExtentReportManager.startTest("Sample Test", "To Check Sample GET Request");
		String baseUri = "https://petstore.swagger.io/";
		String resourceUri="v2/pet/";
		String requestParam = "2";
		String requestBody = "{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"petId\": 0,\r\n"
				+ "  \"quantity\": 0,\r\n"
				+ "  \"shipDate\": \"2023-09-06T15:20:52.376Z\",\r\n"
				+ "  \"status\": \"placed\",\r\n"
				+ "  \"complete\": true\r\n"
				+ "}";
		
		RestManager manager = new RestManager(ContentType.JSON);
		ExtentReportManager.getLogger().log(Status.PASS, "Sending Request to the Server");
		Response response = manager.sendRequest(baseUri, Method.GET, resourceUri, requestParam, null);
		//Post - create post request accordingly
		Response response1 = manager.sendRequest(baseUri, Method.POST, resourceUri, requestParam, requestBody);
		
		if(response.getStatusCode()==200) {
			System.out.println("Pass");
			ExtentReportManager.getLogger().log(Status.PASS, "Request is 200.. ");
		} else {
			ExtentReportManager.getLogger().log(Status.FAIL, "Request is not 200.. ");
			System.out.println("Fail");
		}
		
		PetDetailsObject detailsObject = response.as(PetDetailsObject.class);
		ExtentReportManager.getLogger().log(Status.PASS, "Parsed Response");
		ExtentReportManager.getLogger().log(Status.PASS, "Name of ID from Response - " + detailsObject.getName());
		System.out.println(detailsObject.getCategory().getName());
		ExtentReportManager.endTest();
		ExtentReportManager.extentReports.flush();
		
		
		
	}

}
