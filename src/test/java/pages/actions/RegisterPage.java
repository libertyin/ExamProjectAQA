package pages.actions;

import io.qameta.allure.Step;
import logger.CustomLogger;
import pages.locators.RegisterPageLocators;

public class RegisterPage extends RegisterPageLocators {
    @Step("Fill name field")
    public void fillName(){
        inputName.sendKeys("Ivan Ivanov2");
        CustomLogger.logger.info("ok");
    }

    @Step("Fill email field")
    public void fillEmail(){
        inputEmail.sendKeys("ivan.ivanov2@gmail.com");
        CustomLogger.logger.info("ok");
    }

    @Step("Fill password field")
    public void fillPassword(){
        inputPassword.sendKeys("qwerty1234!@2");
        CustomLogger.logger.info("ok");
    }

    @Step("Fill repeat password field")
    public void fillRepeatPassword(){
        inputRepeatPassword.sendKeys("qwerty1234!@2");
        CustomLogger.logger.info("ok");
    }

    @Step("Click Register button")
    public void clickRegisterButton(){
        buttonRegister.click();
        CustomLogger.logger.info("ok");
    }
}
