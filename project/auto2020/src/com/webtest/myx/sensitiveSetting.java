package com.webtest.myx;

import org.testng.annotations.Test;

import com.webtest.demo.Admin_Login;

public class sensitiveSetting extends Admin_Login{
//	�������дʹ�������
	@Test(priority=1)
	public void test14() throws InterruptedException {
		
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=���д�����");
		webtest.click("id=id_OPEN_SENSITIVE_1");
		webtest.click("xpath=//button[text()='ȷ��']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//	�ر����дʹ�������
	@Test(priority=2)
	public void test15() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=���д�����");
		webtest.click("id=id_OPEN_SENSITIVE_0");
		webtest.click("xpath=//button[text()='ȷ��']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
}