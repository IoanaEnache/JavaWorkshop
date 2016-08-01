package com.endava;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.WebDriver.*;

/**
 * Created by ienache on 7/29/2016.
 */
public class GmailTest {

    static WebDriver webDriver;


    @BeforeClass
    public static void setUP() {

        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://gmail.com");

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void testGmail() throws InterruptedException {

        // get the email field
        WebElement emailField = webDriver.findElement(By.xpath("//input[@id = 'Email']"));
        emailField.sendKeys("ena.ioana");

        // get the next field
        WebElement nextField = webDriver.findElement(By.xpath("//input[@id='next']"));
        nextField.click();

        // get the password field
        WebElement passwordField = webDriver.findElement(By.xpath("//input[@id='Passwd']"));
        passwordField.sendKeys("iPhone92");

        // get the signIn button
        WebElement signInButton = webDriver.findElement(By.xpath("//input[@id='signIn']"));
        signInButton.click();

        //Thread.sleep(5000);

        // get the compose button
        WebElement composeButton = webDriver.findElement(By.xpath("//div[text()='COMPOSE']"));
        composeButton.click();

        // get the to field
        WebElement toField = webDriver.findElement(By.xpath("//textarea[@name='to']"));
        toField.sendKeys("ena.ioana@gmail.com");
        toField.sendKeys(Keys.RETURN);

        // get the subject field
        WebElement subjectField = webDriver.findElement(By.xpath("//input[@name='subjectbox']"));
        subjectField.sendKeys("Test Selenium");

        // get the messsage box
        WebElement messageBox= webDriver.findElement(By.xpath("//div[@aria-label='Message Body']"));
        messageBox.sendKeys("Test made by Ioana");

        // get the send button
        WebElement sendButton= webDriver.findElement(By.xpath("//div[contains(@aria-label,'Send')]"));
        sendButton.click();

        // HOMEWORK
        WebDriverWait wait = new WebDriverWait(webDriver, 10);

        // open the new email
        WebElement viewMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'View message')]")));
        viewMessage.click();

        // click on inbox button
        WebElement inbox = webDriver.findElement(By.xpath("//a[@title='Inbox']"));
        inbox.click();

        // click on existing email
        WebElement mailForSubject = webDriver.findElement(By.xpath("//span[contains(.,'Test Selenium')]"));
        mailForSubject.click();

        // get the subject of the email
        WebElement subject = webDriver.findElement(By.xpath("//h2[contains(.,'Test Selenium')]"));
        String getTheText = subject.getText();
        System.out.println(subject);

        // get the body of the email
        WebElement body = webDriver.findElement(By.xpath("//div[text()='Test made by Ioana']"));
        String getTheBody = body.getText();

        // wait three seconds to load the page
        Thread.sleep(3000);

        // get the title of the page
        String title = webDriver.getTitle();
        System.out.println(title);

        // compare the title
        Assert.assertEquals("Test Selenium - ena.ioana@gmail.com - Gmail", title);
        System.out.println("Assert Passed");

        // compare the subject from the email
        Assert.assertEquals("Test Selenium", getTheText);
        System.out.println("The subject is correct");

        // compare the body from the email
        Assert.assertEquals("Test made by Ioana", getTheBody);
        System.out.println("The body is correct");

    }

    @AfterClass
    public static void tearDown(){

        //webDriver.close();

    }

}
