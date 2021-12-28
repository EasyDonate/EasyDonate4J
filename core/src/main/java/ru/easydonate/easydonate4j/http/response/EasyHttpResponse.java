package ru.easydonate.easydonate4j.http.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface EasyHttpResponse {

    int getCode();

    @NotNull String getMessage();

    @Nullable String getContent();

    boolean isSuccess();

}