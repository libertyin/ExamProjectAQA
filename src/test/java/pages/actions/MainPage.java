package pages.actions;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import logger.CustomLogger;
import pages.locators.MainPageLocators;

public class MainPage extends MainPageLocators {

    @Step("Click Sign in button")
    public void clickSignIn(){
      buttonSignIn.click();
      CustomLogger.logger.info("ok");
    }

    @Step("Check for Profile link to exist")
    public void checkMyProfileLink(){
        linkMyProfile.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }






}
