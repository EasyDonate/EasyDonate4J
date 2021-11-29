package ru.easydonate.sdk.http;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class QueryParams {

    public static final QueryParams EMPTY = new QueryParams(Collections.emptyMap());

    private final Map<String, String> queryParamsMap;

    public QueryParams() {
        this(new LinkedHashMap<>());
    }

    private QueryParams(Map<String, String> queryParamsMap) {
        this.queryParamsMap = queryParamsMap;
    }

    public @NotNull QueryParams copy() {
        return new QueryParams(new LinkedHashMap<>(queryParamsMap));
    }

    public @NotNull QueryParams add(@NotNull String key, @Nullable Object value) {
        return add(key, value, false);
    }

    public @NotNull QueryParams add(@NotNull String key, @Nullable Object value, boolean encode) {
        try {
            String encodedValue = encode ? URLEncoder.encode(String.valueOf(value), "UTF-8") : String.valueOf(value);
            queryParamsMap.compute(key, (k, v) -> v != null ? v + "," + encodedValue : encodedValue);
        } catch (UnsupportedEncodingException ignored) {
        }
        return this;
    }

    public @NotNull QueryParams set(@NotNull String key, @Nullable Object value) {
        return set(key, value, false);
    }

    public @NotNull QueryParams set(@NotNull String key, @Nullable Object value, boolean encode) {
        try {
            String encodedValue = encode ? URLEncoder.encode(String.valueOf(value), "UTF-8") : String.valueOf(value);
            queryParamsMap.put(key, encodedValue);
        } catch (UnsupportedEncodingException ignored) {
        }
        return this;
    }

    public @NotNull Map<String, String> getAsMap() {
        return queryParamsMap;
    }

    public @NotNull String getAsString() {
        if(queryParamsMap.isEmpty())
            return "";

        return "?" + queryParamsMap.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));
    }

}
