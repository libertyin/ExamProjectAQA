package pages.actions;

import io.qameta.allure.Step;
import logger.CustomLogger;
import pages.locators.SignInPageLocators;

public class SignInPage extends SignInPageLocators {

    @Step("Fill email field")
    public void fillEmail(){
        inputEmail.sendKeys("ivan.inanov@gmail.com");
        CustomLogger.logger.info("ok");
    }

    @Step("Fill password field")
    public void fillPassword(){
        inputPassword.sendKeys("12345");
        CustomLogger.logger.info("ok");
    }

    @Step("Click Sign in button")
    public void clickSignIn(){
        buttonSignIn.click();
        CustomLogger.logger.info("ok");
    }

}
