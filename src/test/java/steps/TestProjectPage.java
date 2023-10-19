package steps;

import com.codeborne.selenide.WebDriverRunner;
import elements.TestProjectPageElements;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import junit.framework.AssertionFailedError;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static hooks.WebHooks.prop;


public class TestProjectPage extends TestProjectPageElements {
    @Step("Проверить версию 2.0")
    public static void checkVersion() {
        try {
            Assertions.assertEquals("Version 2.0", version.getText());
            makeScreenShot();
        } catch (AssertionFailedError e) {
            makeScreenShot();
            Assertions.fail("Колличество задач меньше 0");
        }
    }
    @Step("Проверить статус Сделать")
    public static void checkStatusToDo() {
        try {
            Assertions.assertEquals("СДЕЛАТЬ", status.getText());
            makeScreenShot();
        } catch (AssertionFailedError e) {
            makeScreenShot();
            Assertions.fail("Колличество задач меньше 0");
        }
    }
    @Step("Проверить статус Готово")
    public static void checkStatusDone() {
        try {
            Assertions.assertEquals("ГОТОВО", status.getText());
            makeScreenShot();
        } catch (AssertionFailedError e) {
            makeScreenShot();
            Assertions.fail("Колличество задач меньше 0");
        }
    }
    @Step("Перейти к общему списку тестов")
    public static void goToAllTests() {
        open(prop.getProperty("JIRA_TEST_SPACE"));
    }
    @Step("Проверить количество задач")
    public static void checkQuantity() {
        String value = quantity.getText();
        int val = Integer.parseInt(value.substring(5).trim());
        try {
            Assertions.assertTrue(val > 0);
            makeScreenShot();
        } catch (AssertionFailedError e) {
            makeScreenShot();
            Assertions.fail("Колличество задач меньше 0");
        }
    }
    @Step("Перейти на страницу задачи TestSelenium")
    public static void goToSelenTask() {
        quickSearch.sendKeys("TestSelenium");
        selenTask.click();
        makeScreenShot();
    }
    @Step("Создать задачу")
    public static void createBug() {
        create.click();
        makeScreenShot();
    }
    @Step("Заполнить поля задачи")
    public static void fillFields() {
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
        makeScreenShot();
    }
    @Step("Сохранить задачу")
    public static void saveBug() {
        createSaveBtn.click();
        makeScreenShot();
    }
    @Step("Перейти к созданой задаче")
    public static void openCreatedBug() {
        open(prop.getProperty("JIRA_MAIN"));
        lastTask.click();
        makeScreenShot();
    }
    @Step("Исполнить задачу")
    public static void closeBug() {
        workBtn.click();
        bsDrop.click();
        doneBtn.shouldBe(visible, Duration.ofSeconds(5)).click();
        sleep(5000);
        makeScreenShot();
    }
    @Attachment("image/png")
    public static byte[] makeScreenShot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
