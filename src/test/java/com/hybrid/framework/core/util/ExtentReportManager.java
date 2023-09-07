package com.hybrid.framework.core.util;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * 
 * @author MASHALS
 * Description: This Class contains Extent Report Config
 */
public class ExtentReportManager {

	public static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> mapExtentTests = new ThreadLocal<>();
	
	private ExtentReportManager() {	}
	
	public static void initExtentReport() {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Timestamp(new Date().getTime()));
		GlobalConstants.extentReportFileName = "Extent Report " + timeStamp + ".html";
		extentReports = new ExtentReports();		
		ExtentSparkReporter reporter = new ExtentSparkReporter(new File(".") + "//Reports//" + GlobalConstants.extentReportFileName);

		//Load Config File 
		try {
			reporter.loadXMLConfig(new File(".") + "//ExtentReportConfig.xml");
			extentReports.attachReporter(reporter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Start Test Section
	public static ExtentTest startTest(String testName, String description) {
		ExtentTest test = extentReports.createTest(testName, description);
		mapExtentTests.set(test);
		return test;
	}
	
	//Logger
	public static synchronized ExtentTest getLogger() {
		return mapExtentTests.get();
	}
	
	//End of Test
	public static synchronized void endTest() {
		mapExtentTests.get().getExtent().flush();
	}
	
	//System Information
	public static void addSystemInfo() {
		
		//User Info
		extentReports.setSystemInfo("Username", System.getProperty("user.name"));

		//Java Info
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));

	}
}
