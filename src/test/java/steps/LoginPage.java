package steps;

import elements.LoginPageElements;


public class LoginPage extends LoginPageElements {
    public static void authorization() {
        if (userName.exists()) {
            userName.sendKeys("AT9");
            password.sendKeys("Qwerty123");
            enterBtn.click();
        }
    }
}
