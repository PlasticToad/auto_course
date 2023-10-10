package hooks;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static steps.LoginPage.authorization;


public class WebHooks {
    @Before
    public void driverSetup() {
        open("https://edujira.ifellow.ru/");
        getWebDriver().manage().window().maximize();
        authorization();
        sleep(5000);
        open("https://edujira.ifellow.ru/projects/TEST/issues/TEST-22095?filter=allopenissues");
    }
    @Before
    public static void allureSubThreadParallel() {
        String listerName = "AllureSelenide";
        if (!(SelenideLogger.hasListener(listerName))) {
            SelenideLogger.addListener(listerName,
                    (new AllureSelenide().screenshots(true).savePageSource(false)));
        }
    }
}
