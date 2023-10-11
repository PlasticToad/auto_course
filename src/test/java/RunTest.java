import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.ApiSteps.*;
@Epic("Курсы АТ")
@Feature("Тестирование API")
@DisplayName("Тестирование API")

public class RunTest {

    @Test
    @DisplayName("Рик и Морти api")
    @Owner("Боробов")
    public void task1() {
        checkSpeciesLocation("2");//ID Морти(2)
    }


    @Test
    @DisplayName("reqres.in api")
    @Owner("Боробов")
    public void task2() {
        createUser("Tomato", "Eat market");
    }
}
