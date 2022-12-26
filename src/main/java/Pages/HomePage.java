package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}


	@FindBy(id="input-email")
	WebElement Email;


	@FindBy (id ="register-button")
	WebElement RigsterButton;


	public void ClickOnRegisterButton()
	{
		Email.sendKeys("Abdelrahman.elazazy@outlook.com");
		RigsterButton.click();
	}



}
