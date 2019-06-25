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

public class TCTopupATM extends InstanciateDriver {
	@Test
	public void TopupFail_InputInvalidInfo3Times() throws Exception {
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
		topup.chooseATMDomestic();
		topup.chooseVCB();
		topup.InputAmount("10000");
		topup.ChooseAgreeTopup();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		topup.InputCardName("Nguyen van B");
		topup.InputCardNumber("9704000000000018");
		topup.ChooseCardMonth();
		topup.ChooseCardYear();
		for (int i = 0; i < 3; i++) {
			topup.ChooseAgreeTopup_Napas();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Lấy ra mess sau khi thực hiện giao dịch
		String Message = reuseFuntion.GetMessage();
		// Lấy số dư ví chính sau giao dịch
		int AmountNew = reuseFuntion.GetMainWallet();

		// Lấy ra trạng thái giao dịch
		String StatusTransaction = reuseFuntion.GetStatusTransaction();
		System.out.print(Message);
		// Check kết quả
		Assert.assertEquals(AmountOld, AmountNew);
		Assert.assertEquals("Giao dịch thất bại.", Message);
		Assert.assertEquals("Lỗi ngân hàng", StatusTransaction);
	}

	//@Test
	public void TopupFail_CancelTransactionOnNapas() throws Exception {
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
		topup.chooseATMDomestic();
		topup.chooseVCB();
		topup.InputAmount("10000");
		topup.ChooseAgreeTopup();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		topup.ChosseCancelTopup_Napas();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Lấy số dư ví chính sau giao dịch
		int AmountNew = reuseFuntion.GetMainWallet();
		// Lấy ra trạng thái giao dịch
		String StatusTransaction = reuseFuntion.GetStatusTransaction();
		// Check kết quả
		Assert.assertEquals(AmountOld, AmountNew);
		Assert.assertEquals("Khởi tạo", StatusTransaction);
	}
	//@Test
	public void TopupSuccess_WithVietinbank() throws Exception {
		TopupPage topup = PageFactory.initElements(driver, TopupPage.class);
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		ReuseFuntion reuseFuntion = PageFactory.initElements(driver, ReuseFuntion.class);

		// đăng nhập thành công
		reuseFuntion.LoginSuccess("0374441716", "123456");
		// Lấy số dư ví chính trước giao dịch
		int AmountOld = reuseFuntion.GetMainWallet();
		homepage.chooseTransactions();
		homepage.chooseTopup();
		topup.chooseATMDomestic();
		topup.ChooseViettinbank();
		topup.InputAmount("10000");
		topup.InputATMCardHolderNameVTB("nguyen dan linh chi");
		topup.InputATMCardNumberVTB("9704151531339480");
		topup.ChooseMonth04();
		topup.ChooseAgreeViettinbank();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Check gọi sang cổng TP bank thành công
		String Title = driver.getTitle();
		Assert.assertEquals("VietinBank e-Payment", Title);
		//Quay lại senpay check lịch suwe giao dịch và số dư
		driver.get("https://senpay.vn/");
		// Lấy số dư ví chính sau giao dịch
				int AmountNew = reuseFuntion.GetMainWallet();
				// Lấy ra trạng thái giao dịch
				String StatusTransaction = reuseFuntion.GetStatusTransaction();
				// Check kết quả
				Assert.assertEquals(AmountOld, AmountNew);
				Assert.assertEquals("Khởi tạo", StatusTransaction);
	}
	//@Test
	public void TopupSuccess_WithTPbank() throws Exception {
		TopupPage topup = PageFactory.initElements(driver, TopupPage.class);
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		ReuseFuntion reuseFuntion = PageFactory.initElements(driver, ReuseFuntion.class);

		// đăng nhập thành công
		reuseFuntion.LoginSuccess("0374441716", "123456");
		// Lấy số dư ví chính trước giao dịch
		int AmountOld = reuseFuntion.GetMainWallet();
		//Bat dau topup
		homepage.chooseTransactions();
		homepage.chooseTopup();
		topup.chooseATMDomestic();
		topup.ChooseTPbank();
		topup.InputAmount("10000");
		topup.InputATMCardHolderNameTPB("nguyen dan linh chi");
		topup.InputATMCardNumberTPB("9704230080638334");
		topup.ChooseAgreeTPbank();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Check gọi sang cổng TP bank thành công
		String Title = driver.getTitle();
		Assert.assertEquals("TPBank eBanking", Title);
		//Quay lại senpay check lịch suwe giao dịch và số dư
		driver.get("https://senpay.vn/");
		// Lấy số dư ví chính sau giao dịch
				int AmountNew = reuseFuntion.GetMainWallet();
				// Lấy ra trạng thái giao dịch
				String StatusTransaction = reuseFuntion.GetStatusTransaction();
				// Check kết quả
				Assert.assertEquals(AmountOld, AmountNew);
				Assert.assertEquals("Khởi tạo", StatusTransaction);
	}
}
