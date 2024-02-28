import lombok.extern.slf4j.Slf4j;
import org.annotations.FailingTest;
import org.annotations.FlakyTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


@Slf4j
public class TestSandbox2 {

    @FailingTest
    void assertTrueTest() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(false, "true is true");
    }

    @FlakyTest
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
