package ru.easydonate.easydonate4j.http.client.okhttp;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.http.client.AbstractHttpClientBuilder;
import ru.easydonate.easydonate4j.http.client.HttpClient;
import ru.easydonate.easydonate4j.http.client.SimpleTimeouts;

public class OkHttpClientBuilder extends AbstractHttpClientBuilder {

    @Override
    public @NotNull HttpClient create() {
        HttpClient.Timeouts timeouts = new SimpleTimeouts(connectTimeout, responseTimeout, readTimeout, writeTimeout);
        return new OkHttpClient(userAgent, timeouts, apiEndpoint);
    }

}
