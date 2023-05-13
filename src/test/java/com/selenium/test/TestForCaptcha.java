package com.selenium.test;

import com.selenium.base.BaseClass;
import com.selenium.pages.LoginPage;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestForCaptcha extends BaseClass {
    LoginPage loginPage;
    @BeforeMethod
    public void init(){
        setUp();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void LogOntoSscPage() throws TesseractException, IOException, InterruptedException {
        loginPage.loginPageClick();
    }


}
