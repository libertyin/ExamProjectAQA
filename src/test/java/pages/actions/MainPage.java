package pages.actions;

import io.qameta.allure.Step;
import logger.CustomLogger;
import pages.locators.MainPageLocators;

public class MainPage extends MainPageLocators {

    @Step("Click Sign in button")
    public void clickSignIn(){
      buttonSignIn.click();
      CustomLogger.logger.info("ok");
    }




}
