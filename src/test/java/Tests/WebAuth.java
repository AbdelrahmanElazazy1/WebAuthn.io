package Tests;

	import java.util.Base64;
	import java.util.List;

import org.junit.After;
import org.junit.Before;

	import org.openqa.selenium.InvalidArgumentException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.virtualauthenticator.Credential;
	import org.openqa.selenium.virtualauthenticator.HasVirtualAuthenticator;
	import org.openqa.selenium.virtualauthenticator.VirtualAuthenticator;
	import org.openqa.selenium.virtualauthenticator.VirtualAuthenticatorOptions;

	public class WebAuth {

	
	 

	  public WebDriver driver;

	  @Before
	  public void setup() {
	    driver = new ChromeDriver();
	    driver.navigate().to("https://webauthn.io/");
	  }

	  @After
	  public void quit() {
	    driver.quit();
	  }

	  @org.testng.annotations.Test
	  public void testVirtualOptions() {
	    // Create virtual authenticator options
	    VirtualAuthenticatorOptions options = new VirtualAuthenticatorOptions()
	      .setIsUserVerified(true)
	      .setHasUserVerification(true)
	      .setIsUserConsenting(true)
	      .setTransport(VirtualAuthenticatorOptions.Transport.USB)
	      .setProtocol(VirtualAuthenticatorOptions.Protocol.U2F)
	      .setHasResidentKey(false);

	    
	  }

	  @org.testng.annotations.Test
	  public void testCreateAuthenticator() {
	    // Create virtual authenticator options
	    VirtualAuthenticatorOptions options = new VirtualAuthenticatorOptions()
	      .setProtocol(VirtualAuthenticatorOptions.Protocol.U2F)
	      .setHasResidentKey(false);

	    // Register a virtual authenticator
	    VirtualAuthenticator authenticator =
	      ((HasVirtualAuthenticator) driver).addVirtualAuthenticator(options);

	    List<Credential> credentialList = authenticator.getCredentials();

	   
	  }

	
}
