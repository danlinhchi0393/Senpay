package com.senpay.serenity_cucumber.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.senpay.serenity_cucumber.pages.AccountInfoPage;
import com.senpay.serenity_cucumber.pages.HistoryTransactionPage;
import com.senpay.serenity_cucumber.pages.HomePage;
import com.senpay.serenity_cucumber.pages.LoginPage;

import static org.hamcrest.Matchers.hasItem;

public class TransactionHistorySteps extends ScenarioSteps   {

	HomePage homepage;
	HistoryTransactionPage history_transaction;
    
    @Step
    public void choose_topup_history() {
    	homepage.chooseTransactions();
        history_transaction.ChooseTypeTransaction();
        history_transaction.ChooseTopupTransaction();
        history_transaction.ChooseSearch();
    }
    @Step
    public String get_status_transaction_topup() {
    	String status = history_transaction.GetStatusTransaction();
    	return status;
    }
    @Step
	public boolean Check_status_topup(String expect) {
		String status = get_status_transaction_topup();
		System.out.print(status);
		if (status.contentEquals(expect) == true)
			return true;
		return false;
}
}