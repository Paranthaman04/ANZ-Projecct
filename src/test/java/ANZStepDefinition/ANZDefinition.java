package ANZStepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class ANZDefinition {
	
	
	WebDriver driver;
	WebElement AppType;
	WebElement NumDept;
	WebElement PropertyBuy;
	WebElement AnnIncome;
	WebElement AnnOthIncome;
	WebElement LivingExpense;
	WebElement HomeLoans;
	WebElement OtherLoans;
	WebElement OtherMonthlyCom;
	WebElement TotalCreditlimit;
	

@Given("^ANZ web page is loaded$")
public void ANZ_web_page_is_loaded() {
    
	System.setProperty("webdriver.chrome.driver", ".\\soft\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
}

@And("^Click the Single in Application type field$")
public void click_the_Single_in_Application_type_field() {
  
    AppType= driver.findElement(By.xpath("//*[@for='application_type_single']"));
	AppType.click();
}

@And("^Give the (\\d+) dependant in Number of dependants$")
public void give_the_dependant_in_Number_of_dependants(int deptValue) {

	NumDept= driver.findElement(By.xpath("//*[@title='Number of dependants']"));
	Select select = new Select(NumDept);
	select.selectByIndex(deptValue);
	
}

@And("^Click the Home to live in Property you would like to buy field$")
public void click_the_Home_to_live_in_Property_you_would_like_to_buy_field() {
    
	PropertyBuy= driver.findElement(By.xpath("//*[@for='borrow_type_home']"));
	PropertyBuy.click();
}

@And("^Give the (\\d+) in Your annual income field$")
public void give_the_in_Your_annual_income_field(String amount) {
    
	AnnIncome= driver.findElement(By.xpath("//*[@aria-labelledby='q2q1']"));
	AnnIncome.sendKeys(amount);
}

@And("^Give the (\\d+) in Your annual other income field$")
public void give_the_in_Your_annual_other_income_field(String amount) {
    
	AnnOthIncome= driver.findElement(By.xpath("//*[@aria-labelledby='q2q2']"));
	AnnOthIncome.sendKeys(amount);
}

@And("^Give the (\\d+) in Monthly living expenses field$")
public void give_the_in_Monthly_living_expenses_field(String amount) {
   
	LivingExpense= driver.findElement(By.xpath("//*[@id='expenses']"));
	LivingExpense.sendKeys(amount);
}

@And("^Give the (\\d+) in Current home loan monthly repayments field$")
public void give_the_in_Current_home_loan_monthly_repayments_field(String amount) {
    
	HomeLoans= driver.findElement(By.xpath("//*[@id='homeloans']"));
	HomeLoans.sendKeys(amount);
}

@And("^Give the (\\d+) in Other loan monthly repayments field$")
public void give_the_in_Other_loan_monthly_repayments_field(String amount) {

	OtherLoans= driver.findElement(By.xpath("//*[@aria-labelledby='q3q3']"));
	OtherLoans.sendKeys(amount);
}

@And("^Give the (\\d+) in Other monthly commitments field$")
public void give_the_in_Other_monthly_commitments_field(String amount) {
    
	OtherMonthlyCom= driver.findElement(By.xpath("//*[@aria-labelledby='q3q4']"));
	OtherMonthlyCom.sendKeys(amount);
}

@And("^Give the (\\d+) in Total credit card limits field$")
public void give_the_in_Total_credit_card_limits_field(String amount) {
    
	TotalCreditlimit= driver.findElement(By.xpath("//*[@aria-labelledby='q3q5']"));
	TotalCreditlimit.sendKeys(amount);
}


@And("^Click the Work Out how much I could borrow button$")
public void click_the_Work_Out_how_much_I_could_borrow_button() {

	WebElement ClickWorkOut= driver.findElement(By.xpath("//*[@id='btnBorrowCalculater']"));
	ClickWorkOut.click();
}

@Then("^Check the Estimated borrow amount$")
public void check_the_Estimated_borrow_amount() {
    
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		System.out.println("Print Exception: " +e.getMessage());
		
	}
	WebElement BorrowResult= driver.findElement(By.xpath("//*[@id='borrowResultTextAmount']"));
	String ResultText= BorrowResult.getText();
	System.out.println("Estimated Borrow Amount = "+ ResultText);
}

@When("^Clicked Start over button$")
public void clicked_Start_over_button()  {
    
	WebElement StartOver= driver.findElement(By.xpath("//*[@class='result__restart']/child::button"));
	StartOver.click();

}

@Then("^All Text boxs should be cleared$")
public void all_Text_boxs_should_be_cleared() {
   
	boolean reset=true;
	if(AppType.getText().contains("Single")) {
		reset&=true;
	}else {
		reset&=false;
	}
	Select select = new Select(NumDept);
	WebElement option = select.getFirstSelectedOption();
	String defaultItem = option.getText();
	if(defaultItem.equals("0")) {
		reset&=true;
	}else {
		reset&=false;
	}
	if(PropertyBuy.getText().contains("Home to live in")) {
		reset&=true;
	}else {
		reset&=false;
	}
	if(AnnIncome.getAttribute("value").equals("0")) {
		reset&=true;
	}else {
		reset&=false;
	}
	if(AnnOthIncome.getAttribute("value").equals("0")) {
		reset&=true;
	}else {
		reset&=false;
	}
	if(LivingExpense.getAttribute("value").equals("0")) {
		reset&=true;
	}else {
		reset&=false;
	}
	if(HomeLoans.getAttribute("value").equals("0")) {
		reset&=true;
	}else {
		reset&=false;
	}
	if(OtherLoans.getAttribute("value").equals("0")) {
		reset&=true;
	}else {
		reset&=false;
	}
	if(OtherMonthlyCom.getAttribute("value").equals("0")) {
		reset&=true;
	}else {
		reset&=false;
	}
	if(TotalCreditlimit.getAttribute("value").equals("0")) {
		reset&=true;
	}else {
		reset&=false;
	}
	
	if(reset==true) {
		System.out.println("Reset Done");
	}else {
		System.out.println("Reset failed");
	    throw new RuntimeException("Reset failed");
	}
	
}

@Then("^Warning message should be display$")
public void warning_message_should_be_display() {
    
	WebElement BorrowWarning= driver.findElement(By.xpath("//*[@class='borrow__error__text']"));
	String WarningMsg= BorrowWarning.getText();
	System.out.println("Warning Message = "+ WarningMsg);

}

}
