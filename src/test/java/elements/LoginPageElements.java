package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPageElements {
    public static SelenideElement userName = $x("//input[@name='os_username']").as("Поле ввода логина");
    public static SelenideElement password = $x("//input[@name='os_password']").as("Поле ввода логина");
    public static SelenideElement enterBtn = $x("//input[@name='login']").as("Поле ввода логина");
}
