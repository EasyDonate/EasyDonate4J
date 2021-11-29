package ru.easydonate.sdk.http.client.okhttp;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.http.client.HttpClient;
import ru.easydonate.sdk.http.client.HttpClientService;
import ru.easydonate.sdk.http.client.HttpClientServiceType;
import ru.easydonate.sdk.module.ModuleAlreadyRegisteredException;
import ru.easydonate.sdk.module.ModuleRegistrator;
import ru.easydonate.sdk.module.ModuleType;

public final class OkHttpClientService implements HttpClientService {

    public static void register() {
        if(isRegistered())
            throw new ModuleAlreadyRegisteredException(ModuleType.HTTP_CLIENT_SERVICE);

        ModuleRegistrator.get().registerHttpClientService(new OkHttpClientService());
    }

    public static boolean isRegistered() {
        return ModuleRegistrator.httpClientServiceRegistered(OkHttpClientService.class);
    }

    @Override
    public @NotNull HttpClientServiceType getType() {
        return HttpClientServiceType.OKHTTP;
    }

    @Override
    public @NotNull HttpClient.Builder buildClient() {
        return new OkHttpClientBuilder();
    }

}
