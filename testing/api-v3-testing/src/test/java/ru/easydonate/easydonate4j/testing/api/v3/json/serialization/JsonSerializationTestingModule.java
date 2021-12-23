package ru.easydonate.easydonate4j.testing.api.v3.json.serialization;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.*;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.exception.JsonSerializationException;
import ru.easydonate.easydonate4j.module.ModuleRegistrator;
import ru.easydonate.easydonate4j.testing.TestingModule;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public abstract class JsonSerializationTestingModule extends TestingModule {

    protected static final String JSON_RESOURCE_SHOP_PATH_FORMAT = "/json/api/v3/shop/%s.json";
    protected static final String JSON_RESOURCE_PLUGIN_PATH_FORMAT = "/json/api/v3/plugin/%s/%s.json";

    @Test
    @Order(0)
    @DisplayName("Serialization service initialization")
    public void printRegisteredSerializationService() {
        logger.info("Registered serialization service: " + ModuleRegistrator.get().getJsonSerializationService().getType());
    }

    protected final void parseShopModel(@NotNull String resourceName, @NotNull Class<?> modelType) {
        // resource name is not empty
        Assertions.assertTrue(resourceName != null && !resourceName.isEmpty(), "'resourceName' is null or empty");

        // model type is not null
        Assertions.assertNotNull(modelType, "'modelType' is null");

        // resource stream is not null
        InputStream resourceStream = readShopJsonResource(resourceName);
        Assertions.assertNotNull(resourceStream, "'resourceStream' is null");

        // resource as string is not empty
        String resourceAsString = readResourceAsString(resourceStream);
        Assertions.assertTrue(resourceAsString != null && !resourceAsString.isEmpty(), "'resourceAsString' is null or empty");

        // serialization service is registered
        Assertions.assertTrue(ModuleRegistrator.get().isJsonSerializationServiceRegistered(), "JSON serialization service isn't registered");

        try {
            ModuleRegistrator.jsonSerializationService().deserialize(modelType, resourceAsString);
        } catch (JsonSerializationException ex) {
            Assertions.fail(String.format("Couldn't deserialize shop resource '%s' as '%s'", resourceName, modelType.getName()));
            Assertions.fail(ex);
        }
    }

    protected final void parsePluginModel(@NotNull PluginType pluginType, @NotNull String resourceName, @NotNull Class<?> modelType) {
        // plugin type is not null
        Assertions.assertNotNull(pluginType, "'pluginType' is null");

        // resource name is not empty
        Assertions.assertTrue(resourceName != null && !resourceName.isEmpty(), "'resourceName' is null or empty");

        // model type is not null
        Assertions.assertNotNull(modelType, "'modelType' is null");

        // resource stream is not null
        InputStream resourceStream = readPluginJsonResource(pluginType, resourceName);
        Assertions.assertNotNull(resourceStream, "'resourceStream' is null");

        // resource as string is not empty
        String resourceAsString = readResourceAsString(resourceStream);
        Assertions.assertTrue(resourceAsString != null && !resourceAsString.isEmpty(), "'resourceAsString' is null or empty");

        // serialization service is registered
        Assertions.assertTrue(ModuleRegistrator.get().isJsonSerializationServiceRegistered(), "JSON serialization service isn't registered");

        try {
            ModuleRegistrator.jsonSerializationService().deserialize(modelType, resourceAsString);
        } catch (JsonSerializationException ex) {
            Assertions.fail(String.format("Couldn't deserialize plugin resource '%s' as '%s'", resourceName, modelType.getName()));
            Assertions.fail(ex);
        }
    }

    protected final @NotNull String readResourceAsString(@NotNull InputStream resourceStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(resourceStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        return bufferedReader.lines()
                .map(String::trim)
                .collect(Collectors.joining());
    }

    protected final @Nullable InputStream readShopJsonResource(@NotNull String resourceName) {
        String resourcePath = String.format(JSON_RESOURCE_SHOP_PATH_FORMAT, resourceName);
        return getClass().getResourceAsStream(resourcePath);
    }

    protected final @Nullable InputStream readPluginJsonResource(@NotNull PluginType pluginType, @NotNull String resourceName) {
        return readPluginJsonResource(pluginType.getTestingJsonResourceName(), resourceName);
    }

    protected final @Nullable InputStream readPluginJsonResource(@NotNull String resourceDirectory, @NotNull String resourceName) {
        String resourcePath = String.format(JSON_RESOURCE_PLUGIN_PATH_FORMAT, resourceDirectory, resourceName);
        return getClass().getResourceAsStream(resourcePath);
    }

}
