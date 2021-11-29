package ru.easydonate.easydonate4j.http.client.apache;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.http.client.HttpClient;
import ru.easydonate.easydonate4j.http.client.HttpClientService;
import ru.easydonate.easydonate4j.http.client.HttpClientServiceType;
import ru.easydonate.easydonate4j.module.ModuleAlreadyRegisteredException;
import ru.easydonate.easydonate4j.module.ModuleRegistrator;
import ru.easydonate.easydonate4j.module.ModuleType;

public final class ApacheHttpClientService implements HttpClientService {

    public static void register() {
        if(isRegistered())
            throw new ModuleAlreadyRegisteredException(ModuleType.HTTP_CLIENT_SERVICE);

        ModuleRegistrator.get().registerHttpClientService(new ApacheHttpClientService());
    }

    public static boolean isRegistered() {
        return ModuleRegistrator.httpClientServiceRegistered(ApacheHttpClientService.class);
    }

    @Override
    public @NotNull HttpClientServiceType getType() {
        return HttpClientServiceType.APACHE;
    }

    @Override
    public @NotNull HttpClient.Builder buildClient() {
        return new ApacheHttpClientBuilder();
    }

}
