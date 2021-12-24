package ru.easydonate.easydonate4j.testing.callback.api;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.easydonate.easydonate4j.testing.callback.api.ordering.TestClassesOrder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@TestClassesOrder(1)
@DisplayName("EasyDonate4J Testing Framework")
public final class TestingFramework {

    private static final String API_KEY_PROPERTY_KEY = "api.key.path";
    private static final String LOGGING_PROPERTIES_PATH = "/logging.properties";

    private static final Logger LOGGER;
    private static final String API_KEY;

    static {
        loadLoggingProperties();

        LOGGER = Logger.getLogger(TestingFramework.class.getName());
        API_KEY = loadApiKey();
    }

    @Test
    @DisplayName("Initialization")
    public void init() {
        LOGGER.info("Testing Framework has been initialized successfully!");
    }

    public static @NotNull String getApiKey() {
        return API_KEY;
    }

    public static @NotNull Logger getLogger() {
        return LOGGER;
    }

    @SneakyThrows
    private static void loadLoggingProperties() {
        InputStream propertiesResource = TestingFramework.class.getResourceAsStream(LOGGING_PROPERTIES_PATH);
        LogManager.getLogManager().readConfiguration(propertiesResource);
    }

    private static @Nullable String loadApiKey() {
        String apiKeyPath = System.getProperty(API_KEY_PROPERTY_KEY);
        if(apiKeyPath == null || apiKeyPath.isEmpty()) {
            Assertions.fail("The API key file path isn't specified by system property 'api.key.path'!");
            return null;
        }

        Path apiKeyFile = Paths.get(apiKeyPath);

        try {
            List<String> lines = Files.readAllLines(apiKeyFile);
            if(lines.isEmpty()) {
                Assertions.fail("The API key file hasn't an access key!");
                return null;
            }

            String apiKey = lines.get(0);
            if(apiKey == null || apiKey.isEmpty()) {
                Assertions.fail("The API key is invalid!");
                return null;
            }

            LOGGER.info("Using API key: " + apiKey);
            return apiKey;
        } catch (IOException ex) {
            Assertions.fail("Couldn't read the API key file content!");
            Assertions.fail(ex.getClass().getName() + ": " + ex.getMessage());
            return null;
        }
    }

}
