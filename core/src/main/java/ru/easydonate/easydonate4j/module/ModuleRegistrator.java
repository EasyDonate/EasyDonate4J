package ru.easydonate.easydonate4j.module;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.http.client.HttpClientService;
import ru.easydonate.easydonate4j.json.serialization.JsonSerializationService;

public final class ModuleRegistrator {

    private static final ModuleRegistrator INSTANCE = new ModuleRegistrator();

    private HttpClientService httpClientService;
    private JsonSerializationService jsonSerializationService;

    public static @NotNull ModuleRegistrator get() {
        return INSTANCE;
    }

    public static @NotNull HttpClientService httpClientService() throws ModuleNotRegisteredException {
        return INSTANCE.getHttpClientService();
    }

    public static @NotNull JsonSerializationService jsonSerializationService() throws ModuleNotRegisteredException {
        return INSTANCE.getJsonSerializationService();
    }

    public static boolean httpClientServiceRegistered(Class<? extends HttpClientService> serviceClass) {
        return INSTANCE.isHttpClientServiceRegistered() && httpClientService().getClass() == serviceClass;
    }

    public static boolean jsonSerializationServiceRegistered(Class<? extends JsonSerializationService> serviceClass) {
        return INSTANCE.isJsonSerializationServiceRegistered() && jsonSerializationService().getClass() == serviceClass;
    }

    public @NotNull HttpClientService getHttpClientService() throws ModuleNotRegisteredException {
        if(!isHttpClientServiceRegistered())
            throw new ModuleNotRegisteredException(ModuleType.HTTP_CLIENT_SERVICE);

        return httpClientService;
    }

    public @NotNull JsonSerializationService getJsonSerializationService() throws ModuleNotRegisteredException {
        if(!isJsonSerializationServiceRegistered())
            throw new ModuleNotRegisteredException(ModuleType.JSON_SERIALIZATION_SERVICE);

        return jsonSerializationService;
    }

    public void registerHttpClientService(@NotNull HttpClientService httpClientService) {
        this.httpClientService = httpClientService;
    }

    public void registerJsonSerializationService(@NotNull JsonSerializationService jsonSerializationService) {
        this.jsonSerializationService = jsonSerializationService;
    }

    public boolean isHttpClientServiceRegistered() {
        return httpClientService != null;
    }

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
