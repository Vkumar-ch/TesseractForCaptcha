package com.selenium.pages;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "txtUsername")
    WebElement usernameELement;

    @FindBy(id = "txtPassword")
    WebElement passElement;

    @FindBy(xpath = "//img[@id='captchaImg']")
    WebElement captchaELement;

    @FindBy(xpath = "//input[@id='txtCaptcha']")
    WebElement captchaTextElement;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void loginPageClick() throws InterruptedException, IOException, TesseractException {
        Thread.sleep(1000);
        usernameELement.sendKeys("71000973999");
        Thread.sleep(1000);
        passElement.sendKeys("A@8121994841");
        Thread.sleep(1000);
        String path = "C:\\Users\\hp\\IdeaProjects\\TesseractForCaptcha\\Screenshots\\Captcha.png";
        File sourcefile = captchaELement.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(sourcefile,new File(path));

        Tesseract image = new Tesseract();
        image.setDatapath("D:\\Tesseract\\tessdata");
        image.doOCR(new File(path));

        captchaTextElement.sendKeys((CharSequence) captchaELement);
    }



}
