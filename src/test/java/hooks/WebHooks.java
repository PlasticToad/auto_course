package hooks;

import io.cucumber.java.ru.Дано;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static steps.LoginPage.authorization;


public class WebHooks {
    @Дано("Запуск драйвера, вход в систему")
    public void driverSetup() {
        open("https://edujira.ifellow.ru/");
        getWebDriver().manage().window().maximize();
        authorization();
        sleep(5000);
        open("https://edujira.ifellow.ru/projects/TEST/issues/TEST-22095?filter=allopenissues");
    }
}
