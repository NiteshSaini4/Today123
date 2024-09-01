package Utilities_File;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Test_Case_File.TestCase;


public class ExtentReportwithListeners extends TestCase implements ITestListener
{
	ExtentSparkReporter createReport;
	ExtentReports createtest;
	ExtentTest createlog;
	void setup()
	{	
		createReport=new ExtentSparkReporter("DataDrivenReport.html");
		createtest=new ExtentReports();
		createtest.attachReporter(createReport);
		
		createtest.setSystemInfo("Os", "Windown");
		createtest.setSystemInfo("Browser","chrome");
		createtest.setSystemInfo("user", "Nitesh");
		
		createReport.config().setDocumentTitle("MyExtentReport");
		createReport.config().setReportName("ExtentReportToday");
		createReport.config().setTheme(Theme.STANDARD);
	}
	public void onStart(ITestContext Result)
	{	setup();
		System.out.println("onStart");
	}
	public void onFinish(ITestContext Result)
	{ 	createtest.flush();
		System.out.println("onFinish call");
	}
	public void onTestStart(ITestResult Result)
	{
		System.out.println("OntestStart");
	}
	public void onTestSuccess(ITestResult Result)
	{
		createlog=createtest.createTest(Result.getName());
		createlog.log(Status.PASS,MarkupHelper.createLabel("Test case Pass", ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult Result)
	{	try {
		ScreenShot();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		String path="C:\\Users\\user\\Desktop\\Data_DrivenFrame\\ScreenShot\\z1.png";
		createlog=createtest.createTest(Result.getName());
		createlog.log(Status.FAIL,MarkupHelper.createLabel("Test case Fail", ExtentColor.RED));
		createlog.fail("myscreenShot"+createlog.addScreenCaptureFromPath(path));
	}
	public void onTestSkipped(ITestResult Result)
	{
		createlog=createtest.createTest(Result.getName());
		createlog.log(Status.SKIP,MarkupHelper.createLabel("Test case skip", ExtentColor.YELLOW));
	}
}
