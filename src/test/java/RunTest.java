import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RunTest {

    @BeforeEach
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterEach
    public void afterClass() {
        System.out.println("After class");
    }

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
}
