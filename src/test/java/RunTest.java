import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class RunTest {

    @BeforeEach
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterEach
    public void afterClass() {
        System.out.println("After class");
    }

    /*
    //пока не проходили
    @Test
    public void openUrlTest() {
        open("https://demoqa.com/automation-practice-form");
    }
     */

    @Test
    public void Test1() {
        System.out.println("1");
        Assertions.assertEquals("AW", "AW");
    }

    @Test
    public void Test2() {
        System.out.println("2");
        Assertions.assertEquals("AW", "A@W");
    }

    @Test
    public void Test3() {
        System.out.println("3");
        int a = 3;
        int b = 4;
        Assertions.assertEquals(10, a+b);
    }
}
