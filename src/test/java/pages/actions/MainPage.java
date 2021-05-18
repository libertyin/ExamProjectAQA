package pages.actions;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import logger.CustomLogger;
import pages.locators.MainPageLocators;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends MainPageLocators {


    @Step("Check for Profile link to exist")
    public void checkMyProfileLink(){
        linkMyProfile.shouldBe(Condition.visible);
        CustomLogger.logger.info("ok");
    }

    //menu
    @Step("Click the menu link")
    public void clickMenuLink(String linkHref){
        $(byXpath(prepareLinkLocator + linkHref + "']")).click();
        CustomLogger.logger.info("ok");
    }

}
