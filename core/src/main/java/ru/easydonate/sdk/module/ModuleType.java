package ru.easydonate.sdk.module;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ModuleType {

    HTTP_CLIENT_SERVICE("HTTP Client Service"),
    JSON_SERIALIZATION_SERVICE("JSON Serialization Service");

    private final @NotNull String name;

}
