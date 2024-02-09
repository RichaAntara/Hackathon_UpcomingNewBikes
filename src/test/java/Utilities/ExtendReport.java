package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtendReport implements ITestListener {

	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent; //Populate common info on the report
	public ExtentTest test; //Creating Test Case entries in the report and Update status of the test methods

	String repName;

	public void onStart(ITestContext testContext) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		repName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/" + repName); // specify
																										 // location
																										 // of the
																										 // report

		sparkReporter.config().setDocumentTitle("Identify New Bikes Report"); // Title of report
		sparkReporter.config().setReportName("Upcoming Bikes and Popular models Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "ZIGWHEELS");
		extent.setSystemInfo("project_Name", " Identify New Bikes");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub-Module", "Customer");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("Tester Name", "Antara Saha");
		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("operating System", os);
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
	}

	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName()); //Create a new entry in the report
		test.assignCategory(result.getMethod().getGroups()); // to display groups in report
		test.log(Status.PASS, result.getName() + " got successfully executed"); //Update Status
		try {
			String imgPath1 = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath1);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName()); //Create a new entry in the report
		test.assignCategory(result.getMethod().getGroups()); // to display groups in report

		test.log(Status.FAIL, result.getName() + " got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());

		try {
			String imgPath2 = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath2);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + " got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext testContext) {

		extent.flush();

		String pathOfExtentReport = System.getProperty("user.dir") + "\\Reports\\" + repName;
			File extentReport = new File(pathOfExtentReport);

			try {
				Desktop.getDesktop().browse(extentReport.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
