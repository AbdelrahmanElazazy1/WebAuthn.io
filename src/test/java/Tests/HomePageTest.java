package Tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import Pages.HomePage;

public class HomePageTest extends TestBase{

	
	HomePage HomeObject;
	
	@Test
	public void UserCanRigster()
	
	{
		HomeObject = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomeObject.ClickOnRegisterButton();
	}
	
}
