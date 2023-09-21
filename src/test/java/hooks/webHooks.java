package hooks;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static steps.loginPage.authorization;


public class webHooks {
    @BeforeEach
    public void driverSetup() {
        open("https://edujira.ifellow.ru/");
        getWebDriver().manage().window().maximize();
        authorization();
        sleep(5000);
        open("https://edujira.ifellow.ru/projects/TEST/issues/TEST-22095?filter=allopenissues");
    }
}
