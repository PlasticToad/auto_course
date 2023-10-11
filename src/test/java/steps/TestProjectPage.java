package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import elements.TestProjectPageElements;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.opentest4j.AssertionFailedError;

import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class TestProjectPage extends TestProjectPageElements {
    @Step("Проверить версию 2.0")
    @Тогда("Проверка версии")
    public static void checkVersion() {
        version.shouldHave(Condition.exactText("Version 2.0"));
    }
    @Step("Проверить статус Сделать")
    @Тогда("Проверка статуса СДЕЛАТЬ")
    public static void checkStatusToDo() {
        status.shouldHave(Condition.exactText("СДЕЛАТЬ"));
    }
    @Step("проверить статус Готово")
    @Дано("Проверка статуса ГОТОВО")
    public static void checkStatusDone() {
        status.shouldHave(Condition.exactText("ГОТОВО"));
    }
    @Step("Проверить количество задач")
    @Дано("Проверка количества задач")
    public static void checkQuantity() {
        String value = quantity.getText();
        int val = Integer.parseInt(value.substring(5).trim());
        System.out.println("Всего задач: " + val);
        try {
            Assertions.assertTrue(val > 0);
        } catch (AssertionFailedError e) {
            makeScreenShot();
            Assertions.fail("Колличество задач меньше 0");
        }
    }
    @Attachment("image/png")
    public static byte[] makeScreenShot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
    @Step("Перейти на страницу задачи TestSelenium")
    @Дано("Переход на страницу задачи TestSelenium")
    public static void goToSelenTask() {
        quickSearch.sendKeys("TestSelenium");
        selenTask.click();
    }
    @Step("Создать, закрыть задачу")
    @Дано("Проверка создания, закрытия задачи")
    public static void createCloseBug() {
        create.click();
        taskType.click();
        taskType.sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE,"Ошибка");
        subject.sendKeys("Серьезная ошибка в важном модуле");
        description.sendKeys("Что то нажал и все исчезло!");
        versionFix.click();
        priorityDrop.sendKeys(Keys.SHIFT, Keys.HOME, Keys.DELETE,"Highest");
        tags.sendKeys("bugs");
        environment.sendKeys("Везде ничего не работает");
        versionRelate.click();
        relatedTasks.click();
        task.sendKeys("TEST-28235");
        assign.click();
        createSaveBtn.click();
        open("https://edujira.ifellow.ru/");
        lastTask.click();
        workBtn.click();
        bsDrop.click();
        doneBtn.shouldBe(visible, Duration.ofSeconds(5)).click();
        sleep(3000);
        checkStatusDone();
    }
}
