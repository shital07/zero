import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSandbox {

    @Test
    void assertTrueTest() throws InterruptedException {
Thread.sleep(2000);
        assertTrue(true,"true is true");
    }
    @Test
    void assertTrueTestTwo(){

        assertTrue(true,"true is true");
    }
}
