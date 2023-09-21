import hooks.webHooks;
import org.junit.jupiter.api.Test;
import steps.testProjectPage;

import static steps.testProjectPage.*;



public class RunTest extends webHooks {
    @Test
    public void checkTasksQuantity() {
        checkQuantity(); //Выводит количество задач в консоль + асерт, что задач больше 0
    }
    @Test
    public void checkSelenTaskStatusVersion() {
        goToSelenTask();
        checkStatusToDo(); //Асерт на статус СДЕЛАТЬ
        checkVersion(); //Асерт на версию 2.0
    }
    @Test
    public void createBug() {
        testProjectPage.createCloseBug(); //Создает задачу, прогоняет по статусам + Ассерт на статус ГОТОВ
    }
}
