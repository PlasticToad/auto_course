import hooks.WebHooks;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static steps.TestProjectPage.*;


@Epic("Тестирование UI")
@Feature("Тесты с использованием JUnit")
@DisplayName("Тесты с использованием JUnit")
public class RunTest extends WebHooks {
    @Test
    @DisplayName("Тест колличества задач")
    @Owner("Боробов")
    public void checkTasksQuantity() {
        goToAllTests();
        checkQuantity();
    }
    @Test
    @DisplayName("Тест версии и статуса")
    @Owner("Боробов")
    public void checkSelenTaskStatusVersion() {
        goToSelenTask();
        checkStatusToDo();
        checkVersion();
    }
    @Test
    @DisplayName("Тест создания/закрытия задачи")
    @Owner("Боробов")
    public void createCloseBug() {
        createBug();
        fillFields();
        saveBug();
        openCreatedBug();
        closeBug();
        checkStatusDone();
    }
}
