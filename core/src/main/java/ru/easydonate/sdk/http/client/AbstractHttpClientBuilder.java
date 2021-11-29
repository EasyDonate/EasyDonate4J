package ru.easydonate.sdk.http.client;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.Constants;
import ru.easydonate.sdk.util.Validate;

public abstract class AbstractHttpClientBuilder implements HttpClient.Builder {

    protected String userAgent = Constants.USER_AGENT;
    protected long connectTimeout = Constants.CONNECT_TIMEOUT;
    protected long responseTimeout = Constants.RESPONSE_TIMEOUT;
    protected long readTimeout = Constants.READ_TIMEOUT;
    protected long writeTimeout = Constants.WRITE_TIMEOUT;

    @Override
    public HttpClient.@NotNull Builder setConnectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    @Override
    public HttpClient.@NotNull Builder setResponseTimeout(long responseTimeout) {
        this.responseTimeout = responseTimeout;
        return this;
    }

    @Override
    public HttpClient.@NotNull Builder setReadTimeout(long readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    @Override
    public HttpClient.@NotNull Builder setWriteTimeout(long writeTimeout) {
        this.writeTimeout = writeTimeout;
        return this;
    }

    @Override
    public HttpClient.@NotNull Builder setUserAgent(@NotNull String userAgent) {
        Validate.notEmpty(userAgent, "userAgent");
        this.userAgent = userAgent;
        return this;
    }

}
