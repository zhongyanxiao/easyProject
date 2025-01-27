package com.webtest.listen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class JavaMailTestListener extends TestListenerAdapter {
	
	
	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onFinish(testContext);

		ITestNGMethod[] methods = this.getAllTestMethods();
		System.out.println("一共执行了："+methods.length);
		List <ITestResult> faillist=this.getFailedTests();
		int len = faillist.size();
		System.out.println("失败的测试用例"+len+"次");
		String text="";
		for(int i=0;i<len;i++) {
			ITestResult tr=faillist.get(i);
			System.out.println(tr.getInstanceName()+":"+tr.getName()+"失败了"+"\n");
			text+=tr.getInstanceName()+":"+tr.getName()+"失败了"+"\n";
			
		}
		System.out.println(text);
		try {
			FileOutputStream fos1 = new FileOutputStream(new File("D:/demo/test.zip"));
			ZipUtils.toZip("D:\\xinagmushixun\\auto2020\\test-output\\out", fos1, true);
			MailUtil send = new MailUtil();
			send.sendMailUtil("D:/demo/test.zip");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}