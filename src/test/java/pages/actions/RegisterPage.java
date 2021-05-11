package pages.actions;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import logger.CustomLogger;
import pages.locators.RegisterPageLocators;

public class RegisterPage extends RegisterPageLocators {
    @Step("Fill name field")
    public void fillName(String firstName, String lastName){
        inputName.sendKeys(firstName, lastName);
        CustomLogger.logger.info("ok");
    }

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

    @Step("Fill repeat password field")
    public void fillRepeatPassword(String password){
        inputRepeatPassword.sendKeys(password);
        CustomLogger.logger.info("ok");
    }

    @Step("Click Register button")
    public void clickRegisterButton(){
        buttonRegister.click();
        CustomLogger.logger.info("ok");
    }

    @Step("Check warning for empty field Name")
    public void checkWarningEmptyName(){
        nameEmptyWarning.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }
    @Step("Check warning for empty field Email")
    public void checkWarningEmptyEmail(){
        emailEmptyWarning.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }
    @Step("Check warning for empty field Password")
    public void checkWarningEmptyPassword(){
        passwordEmptyWarning.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }

    @Step("Check warning password don't match")
    public void checkWarningPasswordDoNotMatch(){
        passwordDoNotMatchWarning.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }

    @Step("Check wrong email warning")
    public void checkWarningEmailWrongAddress(){
        emailWrongAddressWarning.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }

    @Step("Check same email warning")
    public void checkWarningSameEmail(){
        emailSameAddressWarning.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }
}
