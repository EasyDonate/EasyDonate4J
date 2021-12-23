package ru.easydonate.easydonate4j.testing.api.v3.http.client;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.*;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.module.ModuleRegistrator;
import ru.easydonate.easydonate4j.api.v3.client.EasyDonateClient;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.Plugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.PluginManager;
import ru.easydonate.easydonate4j.api.v3.exception.ApiResponseFailureException;
import ru.easydonate.easydonate4j.json.serialization.JacksonSerializationService;
import ru.easydonate.easydonate4j.api.v3.response.ErrorResponse;
import ru.easydonate.easydonate4j.testing.api.v3.TestingFramework;
import ru.easydonate.easydonate4j.testing.TestingModule;
import ru.easydonate.easydonate4j.testing.api.v3.ordering.TestClassesOrder;

import java.util.concurrent.*;

@TestClassesOrder(3)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public abstract class HttpClientTestingModule extends TestingModule {

    private static final ExecutorService ASYNC_EXECUTOR = Executors.newCachedThreadPool();
    private static final ScheduledExecutorService SCHEDULER = Executors.newSingleThreadScheduledExecutor();
    private static final long REQUEST_DELAY = 1000;

    protected final EasyDonateClient client;

    public HttpClientTestingModule() {
        this.client = EasyDonateClient.create(TestingFramework.getApiKey());
    }

    @BeforeAll
    public static void preInit() {
        if(!JacksonSerializationService.isRegistered())
            JacksonSerializationService.register();
    }

    @Test
    @Order(0)
    @DisplayName("Http client service initialization")
    public void printRegisteredSerializationService() {
        logger.info("Registered http client service: " + ModuleRegistrator.get().getHttpClientService().getType());
    }

    @SneakyThrows
    protected final <T> void makeShopRequestAndValidateNotNull(@NotNull ShopRequestSelector<T> requestSelector) {
        T responseObject = scheduleWithDelay(() -> makeShopRequest(requestSelector)).get();
        Assertions.assertNotNull(responseObject, "'responseObject' is null");
    }

    protected final <T> @Nullable T makeShopRequest(@NotNull ShopRequestSelector<T> requestSelector) {
        try {
            return requestSelector.select(client);
        } catch (ApiResponseFailureException ex) {
            ErrorResponse response = ex.getErrorResponse();
            Assertions.fail(String.format("API failure response received: %s (%s)", response.getErrorDescription(), response.getContent()));
        } catch (HttpRequestException | HttpResponseException ex) {
            Assertions.fail("Couldn't make a GET request", ex);
        }
        return null;
    }

    @SneakyThrows
    protected final <T, P extends Plugin> void makePluginRequestAndValidateNotNull(
            @NotNull PluginSelector<P> pluginSelector,
            @NotNull PluginRequestSelector<T, P> requestSelector
    ) {
        T responseObject = scheduleWithDelay(() -> makePluginRequest(pluginSelector, requestSelector)).get();
        Assertions.assertNotNull(responseObject, "'responseObject' is null");
    }

    protected final <T, P extends Plugin> @Nullable T makePluginRequest(
            @NotNull PluginSelector<P> pluginSelector,
            @NotNull PluginRequestSelector<T, P> requestSelector
    ) {
        PluginManager pluginManager = client.getPluginManager();
        Assertions.assertNotNull(pluginManager, "'pluginManager' is null");

        P plugin = pluginSelector.select(pluginManager);
        Assertions.assertNotNull(plugin, "'plugin' is null");

        try {
            return requestSelector.select(plugin);
        } catch (ApiResponseFailureException ex) {
            ErrorResponse response = ex.getErrorResponse();
            Assertions.fail(String.format("API failure response received: %s (%s)", response.getErrorDescription(), response.getContent()));
        } catch (HttpRequestException | HttpResponseException ex) {
            Assertions.fail("Couldn't make a GET request", ex);
        }
        return null;
    }

    private static <T> @NotNull ScheduledFuture<T> scheduleWithDelay(@NotNull Callable<T> callable) {
        return SCHEDULER.schedule(callable, REQUEST_DELAY, TimeUnit.MILLISECONDS);
    }

    @FunctionalInterface
    protected interface ShopRequestSelector<T> {

        @NotNull T select(@NotNull EasyDonateClient client) throws HttpRequestException, HttpResponseException;

    }

    @FunctionalInterface
    protected interface PluginSelector<P extends Plugin> {

        @NotNull P select(@NotNull PluginManager pluginManager);

    }

    @FunctionalInterface
    protected interface PluginRequestSelector<T, P extends Plugin> {

        @NotNull T select(@NotNull P plugin) throws HttpRequestException, HttpResponseException;

    }

}
