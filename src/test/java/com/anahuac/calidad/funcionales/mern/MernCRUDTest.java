package com.anahuac.calidad.funcionales.mern;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import java.io.File;

//LambdaTest
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

public class MernCRUDTest {
	  //private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  JavascriptExecutor js;
	  
	  //LambdaTest
	  public RemoteWebDriver driver = null;
	  String username = "00378341";
	  String accessKey = "a4j83XWNNuGL6MVtUw03UlCJTNVxyoRtlmCnYR5D8eEZQ1d72M";
	  
	  @Before
	  public void setUp() throws Exception {
		  
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability("platform", "Windows 10");
		  capabilities.setCapability("browserName", "Chrome");
		  capabilities.setCapability("version", "96.0"); // If this cap isn't specified, it will just get the any available one
		  capabilities.setCapability("resolution","2560x1440");
		  capabilities.setCapability("build", "First Test");
		  capabilities.setCapability("name", "Sample Test");
		  capabilities.setCapability("network", true); // To enable network logs
		  capabilities.setCapability("visual", true); // To enable step by step screenshot
		  capabilities.setCapability("video", true); // To enable video recording
		  capabilities.setCapability("console", true); // To capture console logs

		  try {
		    driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);
		  } catch (MalformedURLException e) {
		    System.out.println("Invalid grid URL");
		  } 
		/*  
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");     
        //options.addArguments("--disable-gpu");
        //options.addArguments("--window-size=1920,1080");
        //options.addArguments("--ignore-certificate-errors");
        //options.addArguments("--allow-running-insecure-content");
	    driver = new ChromeDriver(options);
	    baseUrl = "https://mern-crud.herokuapp.com/"; //"http://localhost:3000";
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    js = (JavascriptExecutor) driver;
	    */
	    driver.get(baseUrl);
	    String tag = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody")).getText();
	    while(tag != "") {
	    	pause(1000);
	    	driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button[2]")).click();
		    driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]")).click();
		    pause(1000);
		    tag = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody")).getText();
	    } 	
	  }

	  @Test
	  public void testCreateUser() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();//"//div[@id='root']/div/div[2]/button"
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("userTestCreate");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("userTestCreate@gmail.com");
	    driver.findElement(By.name("age")).click();
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("20");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gender'])[2]/following::div[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Female'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Woah!'])[1]/following::button[1]")).click();
	    pause(1000);
	    String tag = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/div")).getText();
	    assertThat("Nice one!", is(tag));
	  }
	  
	  @Test
	  public void testRetrieveUser() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("userTestRetrieve");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("userTestRetrieve@gmail.com");
	    driver.findElement(By.name("age")).click();
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("20");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gender'])[2]/following::div[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Female'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Woah!'])[1]/following::button[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delete'])[1]/following::div[1]")).click();
	    pause(1000);
	    String tag = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[1]")).getText();
	    assertThat("Usertestretrieve", is(tag));
	  }

	  @Test
	  public void testUpdateUser() throws Exception {
		 driver.get(baseUrl);
		 driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
		 driver.findElement(By.name("name")).click();
		 driver.findElement(By.name("name")).clear();
		 driver.findElement(By.name("name")).sendKeys("userTestUpdate");
		 driver.findElement(By.name("email")).click();
		 driver.findElement(By.name("email")).clear();
		 driver.findElement(By.name("email")).sendKeys("userTestUpdate@gmail.com");
		 driver.findElement(By.name("age")).click();
		 driver.findElement(By.name("age")).clear();
		 driver.findElement(By.name("age")).sendKeys("20");
		 driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gender'])[2]/following::div[1]")).click();
		 driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Female'])[1]/following::span[1]")).click();
		 driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Woah!'])[1]/following::button[1]")).click();
		 driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delete'])[1]/following::div[1]")).click();
		 pause(1000);
		 driver.findElement(By.xpath("/html/body/div[2]/div/i")).click();
		 pause(1000);
		 driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button")).click();
		 driver.findElement(By.name("name")).click();
		 driver.findElement(By.name("name")).clear();
		 driver.findElement(By.name("name")).sendKeys("Usertestupdated");
		 driver.findElement(By.name("email")).click();
		 driver.findElement(By.name("email")).clear();
		 driver.findElement(By.name("email")).sendKeys("usertestupdated@gmail.com");
		 driver.findElement(By.name("age")).click();
		 driver.findElement(By.name("age")).clear();
		 driver.findElement(By.name("age")).sendKeys("21");
		 driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gender'])[2]/following::div[1]")).click();
		 driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Male'])[1]/following::div[2]")).click();
		 driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Woah!'])[1]/following::button[1]")).click();
		 pause(1000);
		 String tag = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p")).getText();
		 assertThat("Successfully updated!", is(tag));
	  }
	    
	  @Test
	  public void testDeleteUser() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
	    driver.findElement(By.name("name")).click();
	    driver.findElement(By.name("name")).clear();
	    driver.findElement(By.name("name")).sendKeys("userTestDelete");
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys("userTestDelete@gmail.com");
	    driver.findElement(By.name("age")).click();
	    driver.findElement(By.name("age")).clear();
	    driver.findElement(By.name("age")).sendKeys("20");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gender'])[2]/following::div[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Female'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Woah!'])[1]/following::button[1]")).click();
	    driver.findElement(By.xpath("/html/body/div[2]/div/i")).click();
	    pause(1000);
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/table/tbody/tr/td[5]/button[2]")).click();
	    driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]")).click();
	    pause(1000);
	    String tag = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody")).getText();
	    assertThat("", is(tag));
	  }
	  
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	  
	  private void pause(long mils) {
		  try {
			  Thread.sleep(mils);
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	  }

}
