package ru.easydonate.easydonate4j.http.client;

import org.jetbrains.annotations.NotNull;

public interface HttpClientService {

    @NotNull HttpClientServiceType getType();

    @NotNull HttpClient.Builder buildClient();

}
