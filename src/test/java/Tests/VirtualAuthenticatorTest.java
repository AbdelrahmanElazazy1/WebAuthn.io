package Tests;
import org.openqa.selenium.edge.EdgeDriver;
import static org.testng.Assert.assertTrue;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandInfo;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.http.HttpMethod;
import org.openqa.selenium.remote.service.DriverCommandExecutor;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.virtualauthenticator.Credential;
import org.openqa.selenium.virtualauthenticator.HasVirtualAuthenticator;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticator;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticatorOptions;
class VirtualAuthenticatorTest{

	static WebDriver driver ;
	//private static VirtualAuthenticator virtualAuthenticatorTest;

	@BeforeTest
	static void setup()

	{

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://webauthn.io/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}


	@Test
	void sampletest() throws Exception{

		setupVirtualAuthenticator();

		driver.findElement(By.id("input-email")).sendKeys("Azazy@1.com");
		driver.findElement(By.xpath("//*[@id=\"advanced-settings\"]/button")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@for=\"optRegRequireUV\"]")).click();
		driver.findElement(By.xpath("//*[@for=\"optAlgES256\"]")).click();
		driver.findElement(By.xpath("//*[@for=\"optAuthRequireUV\"]")).click();
		driver.findElement(By.id("attachment")).sendKeys("Platform");
		driver.findElement(By.id("attestation")).sendKeys("Direct");
		driver.findElement(By.id("discoverableCredential")).sendKeys("Discouraged");
		driver.findElement(By.xpath("//*[@for=\"optAlgRS256\"]")).click();
		driver.findElement(By.id("register-button")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("login-button")).click();

	}


	private void setupVirtualAuthenticator() throws Exception {


		// Create virtual authenticator options
		VirtualAuthenticatorOptions options = new VirtualAuthenticatorOptions()
//				.setIsUserVerified(false)
//				.setHasUserVerification(false)
//				.setIsUserConsenting(true)
				.setProtocol(VirtualAuthenticatorOptions.Protocol.CTAP2)
				.setTransport(VirtualAuthenticatorOptions.Transport.INTERNAL)
				.setHasResidentKey(false);

		// Register a virtual authenticator
		VirtualAuthenticator authenticator = ((HasVirtualAuthenticator) driver).addVirtualAuthenticator(options);




	}



}