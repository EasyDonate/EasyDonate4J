package ru.easydonate.easydonate4j.http.client.jdk.modern;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.http.client.HttpClient;
import ru.easydonate.easydonate4j.http.client.HttpClientService;
import ru.easydonate.easydonate4j.http.client.HttpClientServiceType;
import ru.easydonate.easydonate4j.module.ModuleAlreadyRegisteredException;
import ru.easydonate.easydonate4j.module.ModuleRegistrator;
import ru.easydonate.easydonate4j.module.ModuleType;

public final class JDKModernHttpClientService implements HttpClientService {

    public static void register() {
        if(isRegistered())
            throw new ModuleAlreadyRegisteredException(ModuleType.HTTP_CLIENT_SERVICE);

        ModuleRegistrator.get().registerHttpClientService(new JDKModernHttpClientService());
    }

    public static boolean isRegistered() {
        return ModuleRegistrator.httpClientServiceRegistered(JDKModernHttpClientService.class);
    }

    @Override
    public @NotNull HttpClientServiceType getType() {
        return HttpClientServiceType.JDK_MODERN;
    }

    @Override
    public @NotNull HttpClient.Builder buildClient() {
        return new JDKModernHttpClientBuilder();
    }

}
