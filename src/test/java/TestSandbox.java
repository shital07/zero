import com.typesafe.config.Config;
import core.TestEnvFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j

public class TestSandbox {



    @Test
    void testConfigDevelop() {
        Config config = TestEnvFactory.getInstance().getConfig();
        log.info("TEST_ENV : " + config.getString("TEST_ENV"));
        log.info("TEST_ENV : " + config.getString("CREATE_EMPLOYEE_ENDPOINT"));
        log.info("ADMIN_LOGIN : " + config.getString("ADMIN_PASSWORD"));
        log.info("EMPLOYEE_NAME : " + config.getString("EMPLOYEE_NAME"));


    }

    @Test
    void testConfigStaging() {
        Config config = TestEnvFactory.getInstance().getConfig();
        log.info("TEST_ENV : " + config.getString("TEST_ENV"));
        log.info("TEST_ENV : " + config.getString("CREATE_EMPLOYEE_ENDPOINT"));
        log.info("ADMIN_LOGIN : " + config.getString("ADMIN_PASSWORD"));
        log.info("EMPLOYEE_NAME : " + config.getString("EMPLOYEE_NAME"));


    }
    @Test
    void assertTrueTest() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(true, "true is true");
    }

    @Test
    void assertTrueTestTwo() {

        assertTrue(true, "true is true");
    }
}
