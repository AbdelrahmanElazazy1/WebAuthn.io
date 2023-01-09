package Pages;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.virtualauthenticator.HasVirtualAuthenticator;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticator;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticatorOptions;
import org.testng.annotations.BeforeSuite;

public class HomePage {

	public static WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
	}

	@BeforeSuite
	public void startdriver ()

	{
		System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://webauthn.io/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	// 1- Advanced Settings Button 
	@FindBy (xpath  = "//*[@id=\"advanced-settings\"]/button")
	WebElement AdvancedSettingsButton;


	// 2- Require User Verification Box
	@FindBy(xpath = "//*[@for=\"optRegRequireUV\"]")
	WebElement RequireUserVerificationButton;

	// 3- Support ES256 Box
	@FindBy(xpath = "//*[@for=\"optAlgES256\"]")
	WebElement SupportES256Button;

	// 4- Support RS256 Box
	@FindBy(xpath = "//*[@for=\"optAlgRS256\"]")
	WebElement SupportRS265Button;

	// 5- Authntiactor attachment
	@FindBy(id = "attachment")
	WebElement AuthntiactorAttachmentButton;

	// 6- Authentication Settings , Require User Verification Box
	@FindBy(xpath = "//*[@for=\"optAuthRequireUV\"]")
	WebElement RequireUserAuthenticationButton;

	// 7- AttestationMenu
	@FindBy(id = "attestation")
	WebElement AttestationMenu;

	// 8- Discoverable Credential
	@FindBy(id="discoverableCredential")
	WebElement DiscoverableCredentialButton;



	@FindBy(id="input-email")
	WebElement Email;

	@FindBy (id ="register-button")
	WebElement RigsterButton;

	@FindBy(id ="login-button")
	WebElement AuthenticateButton;




	public void ClickOnRegisterButton()
	{
		Email.sendKeys("Abdelrahman.elazazy@outlook.com");
		AdvancedSettingsButton.click();
		RequireUserVerificationButton.click();
		SupportES256Button.click();
		SupportRS265Button.click();
		AuthntiactorAttachmentButton.click();
		AuthntiactorAttachmentButton.sendKeys("Platform");
		RequireUserAuthenticationButton.click();
		AttestationMenu.click();
		AttestationMenu.sendKeys("Direct");
		DiscoverableCredentialButton.click();
		DiscoverableCredentialButton.sendKeys("Discouraged");
		RigsterButton.click();
		AuthenticateButton.click();

	}



	public void setupVirtualAuthenticator() throws Exception

	{
		// Create virtual authenticator options
		VirtualAuthenticatorOptions options = new VirtualAuthenticatorOptions()
				//.setIsUserVerified(true)
				//.setHasUserVerification(true)
				//.setIsUserConsenting(true)
				.setProtocol(VirtualAuthenticatorOptions.Protocol.CTAP2)
				.setTransport(VirtualAuthenticatorOptions.Transport.INTERNAL)
				.setHasResidentKey(false);

		// Register a virtual authenticator
		VirtualAuthenticator authenticator = ((HasVirtualAuthenticator) driver).addVirtualAuthenticator(options);


	}








}
