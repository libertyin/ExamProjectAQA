package pages.actions;

import io.qameta.allure.Step;
import logger.CustomLogger;
import pages.locators.SignInPageLocators;

public class SignInPage extends SignInPageLocators {

    @Step("Fill email field")
    public void fillEmail(String email){
        inputEmail.sendKeys(email);
        CustomLogger.logger.info("ok");
    }

    @Step("Fill password field")
    public void fillPassword(String password){
        inputPassword.sendKeys(password);
        CustomLogger.logger.info("ok");
    }

    @Step("Click Sign in button")
    public void clickSignIn(){
        buttonSignIn.click();
        CustomLogger.logger.info("ok");
    }

    @Step("Redirect to Registration page")
    public void clickRegistrationLink(){
        linkRegistration.click();
        CustomLogger.logger.info("ok");
    }
}
