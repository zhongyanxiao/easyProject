package com.webtest.core;

import java.io.IOException;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class WebTestListener2 extends TestListenerAdapter {

//	@Override
//	public void onFinish(ITestContext testContext) {
//		// TODO Auto-generated method stub
////		super.onFinish(testContext);
////		打印出总的测试用例数目
//		ITestNGMethod[] methods = this.getAllTestMethods();
//		System.out.println("-共执行了: " + methods.length);
////		成功的失败的测试用例名称和数目
//		List<ITestResult> failList = this.getFailedTests();
//		int len = failList.size();
//		System.out.println("失败的测试用例: " + len);
//		for (int i = 0; i < len; i++) {
//			ITestResult tr = failList.get(i);
//			System.out.println(tr.getInstanceName() + ":" + tr.getName() + "失败了");
//
//		}
//		List<ITestResult> failList2 = this.getPassedTests();
//		int len2 = failList.size();
//		System.out.println("成功的测试用例: " + len2);
//		for (int i = 0; i < len2; i++) {
//			ITestResult tr = failList2.get(i);
//			System.out.println(tr.getInstanceName() + ":" + tr.getName() + "成功了");
//
//		}
//
////		发送邮件
//	}

	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
//		super.onTestFailure(tr);
//		失败的测试用例截屏

		BaseTest tb = (BaseTest) tr.getInstance();
		SeleniumScreenShot screenShot = new SeleniumScreenShot(tb.getDriver());
		try {
			screenShot.screenShot();
			System.out.println("onTestFailure" + tr.getInstanceName() + ":" + tr.getName() + "失败了");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
