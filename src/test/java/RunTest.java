import org.junit.jupiter.api.Test;

import static api.ApiSteps.*;

public class RunTest {
    @Test
    public void task1() {
        checkSpeciesLocation("2");//ID Морти(2)
    }
    @Test
    public void task2() {
        createUser("Tomato", "Eat market");
    }
}
