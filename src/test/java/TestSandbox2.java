import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;





@Slf4j
public class TestSandbox2 {

    @Tag("failing")
    @Test
    void assertTrueTest() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(false, "true is true");
    }

    @Tag("flaky")
    @Test
    void assertTrueTestTwo() {

        long time = System.currentTimeMillis();
        log.info("currentTimeStamp: {}", time);

        if (time % 2 == 0) {
            assertTrue(true, "Time is even");
        } else {
            assertTrue(false, "Time is odd");
        }


    }
}
