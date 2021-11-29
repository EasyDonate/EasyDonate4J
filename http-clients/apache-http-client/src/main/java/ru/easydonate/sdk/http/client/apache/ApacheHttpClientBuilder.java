package ru.easydonate.sdk.http.client.apache;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.http.client.AbstractHttpClientBuilder;
import ru.easydonate.sdk.http.client.HttpClient;
import ru.easydonate.sdk.http.client.SimpleTimeouts;

public class ApacheHttpClientBuilder extends AbstractHttpClientBuilder {

    @Override
    public @NotNull HttpClient create() {
        HttpClient.Timeouts timeouts = new SimpleTimeouts(connectTimeout, responseTimeout, readTimeout, writeTimeout);
        return new ApacheHttpClient(userAgent, timeouts);
    }

}
