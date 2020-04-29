package com.XYZBanking.utilities;

	import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
	import org.testng.ITestResult;
	import org.testng.TestListenerAdapter;
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	public class Reporting extends TestListenerAdapter{

		public ExtentHtmlReporter htmlReporter;
		public ExtentReports extent;
		public ExtentTest test;
		
		public void onStart (ITestContext testContext)
		{
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String repName = "Test-Report- "+timeStamp+".html";
			
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/"+repName);
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml"); 
			
			htmlReporter.config().setDocumentTitle("Automation Report");
			htmlReporter.config().setReportName("Banking Test Report");
			htmlReporter.config().setTheme(Theme.DARK);
			
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Project Name", "XYZ Banking Project");
			extent.setSystemInfo("Host Name", "Local Host");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("user", "Manish");		
		}
		

		public void onTestSuccess(ITestResult testResult)
		{
			test = extent.createTest(testResult.getName());
			test.log(Status.PASS, MarkupHelper.createLabel(testResult.getTestName(),ExtentColor.GREEN));
		}
		
		public void  onTestFailure(ITestResult testResult)
		{
			test = extent.createTest(testResult.getName());
			test.log(Status.FAIL, MarkupHelper.createLabel(testResult.getTestName(),ExtentColor.RED));
			
			String screenShotPath = System.getProperty("user.dir")+"\\Screenshots\\" +testResult.getName()+" .png";
			
			File f = new File(screenShotPath);
			
			if(f.exists())
			{
				try
				{
					test.fail("ScreenShot is Below : "+ test.addScreenCaptureFromPath(screenShotPath));
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		public void onTestSkipped(ITestResult testResult)
		{
			test = extent.createTest(testResult.getName());
			test.log(Status.SKIP, MarkupHelper.createLabel(testResult.getTestName(),ExtentColor.ORANGE));
		}
		
		public void onFinish(ITestContext testContext)
		{
			extent.flush();
		}
	}

