package Tests;

import java.lang.reflect.Method;
import java.util.Map;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticator;
import org.openqa.selenium.virtualauthenticator.HasVirtualAuthenticator;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticator;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticatorOptions;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandInfo;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.http.HttpMethod;
import org.openqa.selenium.remote.service.DriverCommandExecutor;
import org.testng.annotations.Test;
import Pages.HomePage;


public class HomePageTest extends TestBase{


	HomePage homeObject;


	@Test
	public void UserCanRegister() throws Exception

	{
		homeObject = new HomePage(driver);
		homeObject.setupVirtualAuthenticator();
		homeObject.ClickOnRegisterButton();
		
	}


	


}

