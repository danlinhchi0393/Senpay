package Testcase;

import org.testng.annotations.Test;

import Pages.Constant;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;

public class TCTopup {
	Models.mLogin Login = new Models.mLogin();
	Models.mTopup Topup = new Models.mTopup();
    Models.mCommon Common = new Models.mCommon();
	@Test
	public void TopupSuccess() {
		Common.chooseTransactions();
		Common.chooseTopup();
		Topup.chooseATMDomestic();
		Topup.chooseVCB();
		Topup.InputAmount();
		Topup.AgreeTopup();
		Topup.InputValidInforATM();	
	}
	@Test
	public void TopupFail_InputInvalidInfo3Times() {
		int walletOld = Common.CheckWallet();
		Common.chooseTransactions();
		Common.chooseTopup();
		Topup.chooseATMDomestic();
		Topup.chooseVCB();
		Topup.InputAmount();
		Topup.AgreeTopup();
		Topup.InputInValidInforATM();	
		Topup.AgreeInforATM();
		Topup.AgreeInforATM();
		Topup.AgreeInforATM();
		Constant.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Message = Common.GetMessage();
		int walletNew = Common.CheckWallet();
		String Status = Common.CheckTransactionHistory();
		Assert.assertEquals(walletOld, walletNew);
		Assert.assertEquals("Lỗi ngân hàng", Status);
		Assert.assertEquals("Giao dịch thất bại.", Message);
	}
	@Test
	public void TopupFail_CancelTransaction() {
		int walletOld = Common.CheckWallet();
		Common.chooseTransactions();
		Common.chooseTopup();
		Topup.chooseATMDomestic();
		Topup.chooseVCB();
		Topup.InputAmount();
		Topup.AgreeTopup();
		Topup.CancelTopup();
		Constant.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int walletNew = Common.CheckWallet();
		String Status = Common.CheckTransactionHistory();
		Assert.assertEquals(walletOld, walletNew);
		Assert.assertEquals("Khởi tạo", Status);
	}
	

	@BeforeTest
	public void beforeTest() {
		Login.openBrowser();
		Login.login();
		
	}

	@AfterTest
	public void Close_window() {
		Constant.driver.close();
	}

}
