package pages;

import pages.actions.MainPage;
import pages.actions.RegisterPage;
import pages.actions.SignInPage;
import runner.Debug;

public class BaseItPlatform extends Debug {
    public MainPage mainPage = new MainPage();
    public SignInPage signInPage = new SignInPage();
    public RegisterPage registerPage = new RegisterPage();
}
