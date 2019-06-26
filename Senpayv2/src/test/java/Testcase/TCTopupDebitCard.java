package Testcase;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PagesModel.AccountInfoPage;
import PagesModel.HistoryTransactionPage;
import PagesModel.HomePage;
import PagesModel.LoginPage;
import PagesModel.ReuseFuntion;
import PagesModel.TopupPage;
import base.InstanciateDriver;

public class TCTopupDebitCard extends InstanciateDriver {
	String AmountTopup = "100000";
@Test
	public void TopupPass_InputValid3DCard() throws Exception {
		TopupPage topup = PageFactory.initElements(driver, TopupPage.class);
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		ReuseFuntion reuseFuntion = PageFactory.initElements(driver, ReuseFuntion.class);

		// đăng nhập thành công
		reuseFuntion.LoginSuccess("0374441716", "123456");
		// Lấy số dư ví chính trước giao dịch
		int AmountOld = reuseFuntion.GetMainWallet();
		// Thực hiện giao dịch nạp tiền
		homepage.chooseTransactions();
		homepage.chooseTopup();
		topup.ChooseDebitCard();
		topup.ChooseVisa();
		topup.InputAmountTopupInternal(AmountTopup);
		topup.InputInternalCardName("Nguyen Dan Linh Chi");
		topup.InputInternalCardNumber("4000000000000002");
		//topup.ChooseInternalCardMonth();
		//topup.ChooseInternalCardMonth06();
		//topup.ChooseInternalCardyear();
		//topup.ChooseInternalCardYear2020();
		topup.InputInternalCCV("123");
		topup.ChooseInternalAgree();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		topup.InputCBSPassword("1234");
		topup.ChooseCBSAgree();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Lấy ra mess sau khi thực hiện giao dịch
		//String Message = reuseFuntion.GetMessage();
		// Lấy số dư ví chính sau giao dịch
		int AmountNew = reuseFuntion.GetMainWallet();
		System.out.print(AmountNew);
		// Lấy ra trạng thái giao dịch
		String StatusTransaction = reuseFuntion.GetStatusTransaction();
		System.out.print(StatusTransaction);
		// Check kết quả
		Assert.assertEquals(AmountOld+Integer.parseInt(AmountTopup), AmountNew);
		// Assert.assertEquals("Giao dịch thất bại.", Message);
		Assert.assertEquals("Hoàn thành", StatusTransaction);
	}

	
}
