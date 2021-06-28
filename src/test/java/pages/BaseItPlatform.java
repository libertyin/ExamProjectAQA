package pages;

import pages.actions.ArticlePage;
import pages.actions.MainPage;
import pages.actions.RegisterPage;
import pages.actions.SignInPage;
import runner.BrowserstackRunner;
import runner.SelenoidRunner;

public class BaseItPlatform extends BrowserstackRunner {
    public MainPage mainPage = new MainPage();
    public SignInPage signInPage = new SignInPage();
    public RegisterPage registerPage = new RegisterPage();
    public ArticlePage articlePage = new ArticlePage();
}
