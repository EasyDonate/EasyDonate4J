package ru.easydonate.easydonate4j.http.client;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.Constants;
import ru.easydonate.easydonate4j.util.Validate;

public abstract class AbstractHttpClientBuilder implements HttpClient.Builder {

    protected String apiEndpoint = null;
    protected String userAgent = Constants.USER_AGENT;
    protected long connectTimeout = Constants.CONNECT_TIMEOUT;
    protected long responseTimeout = Constants.RESPONSE_TIMEOUT;
    protected long readTimeout = Constants.READ_TIMEOUT;
    protected long writeTimeout = Constants.WRITE_TIMEOUT;

    @Override
    public @NotNull HttpClient.Builder setApiEndpoint(@NotNull String apiEndpoint) {
        Validate.notEmpty(apiEndpoint, "apiEndpoint");
        this.apiEndpoint = apiEndpoint;
        return this;
    }

    @Override
    public @NotNull HttpClient.Builder setConnectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    @Override
    public @NotNull HttpClient.Builder setResponseTimeout(long responseTimeout) {
        this.responseTimeout = responseTimeout;
        return this;
    }

    @Override
    public @NotNull HttpClient.Builder setReadTimeout(long readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    @Override
    public @NotNull HttpClient.Builder setWriteTimeout(long writeTimeout) {
        this.writeTimeout = writeTimeout;
        return this;
    }

    @Override
    public @NotNull HttpClient.Builder setUserAgent(@NotNull String userAgent) {
        Validate.notEmpty(userAgent, "userAgent");
        this.userAgent = userAgent;
        return this;
    }

}
