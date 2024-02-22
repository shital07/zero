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


        String testEnvDirectory = String.format("src/main/resources/%s", testEnv);
        File testEnvAllFiles = new File(testEnvDirectory);


        for (File file : testEnvAllFiles.listFiles()) {

            Config childConfig = ConfigFactory.load(String.format("%s/%s", testEnv, file.getName()));
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
