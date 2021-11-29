package ru.easydonate.sdk.http.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor
public final class SimpleTimeouts implements HttpClient.Timeouts {

    private final long connectTimeout;
    private final long responseTimeout;
    private final long readTimeout;
    private final long writeTimeout;

    @Override
    public @NotNull String toString() {
        return "SimpleTimeouts{" +
                "connectTimeout=" + connectTimeout +
                ", responseTimeout=" + responseTimeout +
                ", readTimeout=" + readTimeout +
                ", writeTimeout=" + writeTimeout +
                '}';
    }

}
