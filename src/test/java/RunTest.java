import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

import static api.ApiSteps.*;

public class RunTest {
    @Epic("Рик и Морти api")
    @Feature("Сравнение расы и локации двух персонажей")
    @Owner("Боробов")
    @Test
    public void task1() {
        checkSpeciesLocation("2");//ID Морти(2)
    }

    @Epic("reqres.in api")
    @Feature("Создание пользователя + проверка ответа")
    @Owner("Боробов")
    @Test
    public void task2() {
        createUser("Tomato", "Eat market");
    }
}
