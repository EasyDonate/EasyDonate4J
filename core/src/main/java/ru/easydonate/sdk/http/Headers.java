package ru.easydonate.sdk.http;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Headers {

    public static final Headers EMPTY = new Headers(Collections.emptyMap());

    private final Map<String, String> headersMap;

    public Headers() {
        this(new LinkedHashMap<>());
    }

    private Headers(Map<String, String> headersMap) {
        this.headersMap = headersMap;
    }

    public @NotNull Headers copy() {
        return new Headers(new LinkedHashMap<>(headersMap));
    }

    public @NotNull Headers add(@NotNull String key, @Nullable Object value) {
        try {
            String encodedValue = URLEncoder.encode(String.valueOf(value), "UTF-8");
            headersMap.compute(key, (k, v) -> v != null ? v + "," + encodedValue : encodedValue);
        } catch (UnsupportedEncodingException ignored) {
        }
        return this;
    }

    public @NotNull Headers set(@NotNull String key, @Nullable Object value) {
        try {
            String encodedValue = URLEncoder.encode(String.valueOf(value), "UTF-8");
            headersMap.put(key, encodedValue);
        } catch (UnsupportedEncodingException ignored) {
        }
        return this;
    }

    public @NotNull Map<String, String> getAsMap() {
        return headersMap;
    }

}
