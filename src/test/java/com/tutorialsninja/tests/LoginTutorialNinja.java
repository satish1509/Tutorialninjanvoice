package com.tutorialsninja.tests;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTutorialNinja {
	@Test(priority=1)
	public void verifyLoginWithValidCredentials() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://tutorialsninja.com/demo/");
	driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	driver.findElement(By.linkText("Login")).click();
	driver.findElement(By.id("input-email")).sendKeys("satishkumar@ramanasoft.com");
	driver.findElement(By.id("input-password")).sendKeys("Satti@0915");
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	driver.quit();
	}
    public String generateEmailTimeStamp() {
    	Date date = new Date();
    	return date.toString().replace(" ","_").replace(":","_")+"@gmail.com";
    }
    @Test(priority=2)
    public void verifyLoginWithInvalidCredentials() {
    	WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://tutorialsninja.com/demo/");
    	driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
    	driver.findElement(By.linkText("Login")).click();
    	driver.findElement(By.id("input-email")).sendKeys(generateEmailTimeStamp());
    	driver.findElement(By.id("input-password")).sendKeys("1234567890");
    	driver.findElement(By.xpath("//input[@value='Login']")).click();
    	Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
    	driver.quit();
    }
}
