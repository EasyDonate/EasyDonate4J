package ru.easydonate.easydonate4j.v3.response;

import org.jetbrains.annotations.Nullable;

public interface ApiResponse<T> {

    boolean isSuccess();

    @Nullable T getContent();

}
