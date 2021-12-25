package ru.easydonate.easydonate4j.module;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.http.client.HttpClientService;
import ru.easydonate.easydonate4j.json.serialization.JsonSerializationService;

/**
 * The modules' registration manager.
 * @author soknight
 */
public final class ModuleRegistrator {

    private static final ModuleRegistrator INSTANCE = new ModuleRegistrator();

    private HttpClientService httpClientService;
    private JsonSerializationService jsonSerializationService;

    /**
     * Get the static instance.
     * @return The registrator instance.
     */
    public static @NotNull ModuleRegistrator get() {
        return INSTANCE;
    }

    /**
     * Get the registered HTTP client service implementation.
     * @return The registered HTTP client service implementation.
     * @throws ModuleNotRegisteredException When there are no service implementation registered yet.
     */
    public static @NotNull HttpClientService httpClientService() throws ModuleNotRegisteredException {
        return INSTANCE.getHttpClientService();
    }

    /**
     * Get the registered JSON serialization service implementation.
     * @return The registered JSON serialization service implementation.
     * @throws ModuleNotRegisteredException When there are no service implementation registered yet.
     */
    public static @NotNull JsonSerializationService jsonSerializationService() throws ModuleNotRegisteredException {
        return INSTANCE.getJsonSerializationService();
    }

    /**
     * Check is yours service class is registered as the HTTP client service.
     * @param serviceClass the service class to check.
     * @return A boolean value - the check result.
     */
    public static boolean httpClientServiceRegistered(Class<? extends HttpClientService> serviceClass) {
        return INSTANCE.isHttpClientServiceRegistered() && httpClientService().getClass() == serviceClass;
    }

    /**
     * Check is yours service class is registered as the JSON serialization service.
     * @param serviceClass the service class to check.
     * @return A boolean value - the check result.
     */
    public static boolean jsonSerializationServiceRegistered(Class<? extends JsonSerializationService> serviceClass) {
        return INSTANCE.isJsonSerializationServiceRegistered() && jsonSerializationService().getClass() == serviceClass;
    }

    /**
     * Get the registered HTTP client service implementation.
     * @return The registered HTTP client service implementation.
     * @throws ModuleNotRegisteredException When there are no service implementation registered yet.
     */
    public @NotNull HttpClientService getHttpClientService() throws ModuleNotRegisteredException {
        if(!isHttpClientServiceRegistered())
            throw new ModuleNotRegisteredException(ModuleType.HTTP_CLIENT_SERVICE);

        return httpClientService;
    }

    /**
     * Get the registered JSON serialization service implementation.
     * @return The registered JSON serialization service implementation.
     * @throws ModuleNotRegisteredException When there are no service implementation registered yet.
     */
    public @NotNull JsonSerializationService getJsonSerializationService() throws ModuleNotRegisteredException {
        if(!isJsonSerializationServiceRegistered())
            throw new ModuleNotRegisteredException(ModuleType.JSON_SERIALIZATION_SERVICE);

        return jsonSerializationService;
    }

    /**
     * Register a new HTTP client service implementation.
     * @param httpClientService the service implementation to register.
     */
    public void registerHttpClientService(@NotNull HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }

    /**
     * Register a new JSON serialization service implementation.
     * @param jsonSerializationService the service implementation to register.
     */
    public void registerJsonSerializationService(@NotNull JsonSerializationService jsonSerializationService) {
        this.jsonSerializationService = jsonSerializationService;
    }

    /**
     * Check is any HTTP client service is registered now.
     * @return A boolean value: the check result.
     */
    public boolean isHttpClientServiceRegistered() {
        return httpClientService != null;
    }

    /**
     * Check is any JSON serialization service is registered now.
     * @return A boolean value: the check result.
     */
    public boolean isJsonSerializationServiceRegistered() {
        return jsonSerializationService != null;
    }

    @Override
    public @NotNull String toString() {
        return "ModuleRegistrator{" +
                "httpClient=" + httpClientService +
                ", jsonSerialization=" + jsonSerializationService +
                '}';
    }

}
