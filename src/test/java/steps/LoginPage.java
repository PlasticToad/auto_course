package steps;

import elements.LoginPageElements;
import io.qameta.allure.Step;


public class LoginPage extends LoginPageElements {
    @Step("Авторизация в системе")
    public static void authorization() {
        if (userName.exists()) {
            userName.sendKeys("AT9");
            password.sendKeys("Qwerty123");
            enterBtn.click();
        }
    }
}
