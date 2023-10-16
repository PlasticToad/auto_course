import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.ApiSteps.*;
@Epic("Тестирование API")
@Feature("Рик и Морти и reqres.in api")
@DisplayName("Рик и Морти и reqres.in api")

public class RunTest {

    @Story("Рик и Морти api")
    @Test
    @DisplayName("Сравнение расы и локации двух персонажей")
    @Owner("Боробов")
    public void task1() {
        rickAndMortyApiTest("2");
    }


    @Story("reqres.in api")
    @Test
    @DisplayName("Создание пользователя")
    @Owner("Боробов")
    public void task2() {
        createUser("Tomato", "Eat market");
    }
}
