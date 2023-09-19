package hooks;

import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class webHooks {
    @BeforeAll
    public static void driverSetup() {
        open("https://edujira.ifellow.ru/");
        getWebDriver().manage().window().maximize();
    }
}
