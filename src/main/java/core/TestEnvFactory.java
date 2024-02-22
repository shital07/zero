package core;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class TestEnvFactory {

    private static final TestEnvFactory UNIQUE_INSTANCE = new TestEnvFactory();
    private Config config;

    private TestEnvFactory() {
        config = setConfig();
    }

    public static TestEnvFactory getInstance() {

        return UNIQUE_INSTANCE;
    }

    private Config setConfig() {

        log.info("setConfig is called");
        config = ConfigFactory.load();
        TestEnv testEnv = config.getEnum(TestEnv.class, "TEST_ENV");
        String testEnvName = testEnv.toString().toLowerCase();
        String testEnvDirectory = String.format("src/main/resources/%s", testEnvName);
        File testEnvAllFiles = new File(testEnvDirectory);


        for (File file : testEnvAllFiles.listFiles()) {

            String filePath = String.format("%s/%s", testEnvName, file.getName());
            log.info(filePath);
            Config childConfig = ConfigFactory.load(filePath);
            config = config.withFallback(childConfig);
            log.debug("Merged Config: {}", config.root().render());
        }
        return config;

    }

    public Config getConfig() {
        log.info("getConfig is called");
        return config;

    }

}
