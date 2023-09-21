package steps;

import elements.testProjectPageElements;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class testProjectPage extends testProjectPageElements {
    public static void checkVersion() {
        Assertions.assertEquals("Version 2.0", version.getText());
    }
    public static void checkStatusToDo() {
        Assertions.assertEquals("СДЕЛАТЬ", status.getText());
    }
    public static void checkStatusDone() {
        Assertions.assertEquals("ГОТОВО", status.getText());
    }
    public static void checkQuantity() {
        String value = quantity.getText();
        int val = Integer.parseInt(value.substring(5).trim());
        System.out.println("Всего задач: " + val);
        Assertions.assertTrue(val > 0);
    }
    public static void goToSelenTask() {
        quickSearch.sendKeys("TestSelenium");
        selenTask.click();
    }
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
//        sprint.sendKeys("Доска Спринт 1");//Руками все ОК. Автотест либо висит, либо не находит значение
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
