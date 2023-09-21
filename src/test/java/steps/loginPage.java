package steps;

import elements.loginPageElements;


public class loginPage extends loginPageElements {
    public static void authorization() {
        if (userName.exists()) {
            userName.sendKeys("AT9");
            password.sendKeys("Qwerty123");
            enterBtn.click();
        }
    }
}
