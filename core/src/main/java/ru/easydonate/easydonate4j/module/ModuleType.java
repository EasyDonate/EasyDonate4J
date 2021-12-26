package ru.easydonate.easydonate4j.module;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * The enum that represents all available module types.
 * @author soknight
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ModuleType {

    /** Represents the HTTP client service module type. */
    HTTP_CLIENT_SERVICE("HTTP Client Service"),

    /** Represents the JSON serialization service module type. */
    JSON_SERIALIZATION_SERVICE("JSON Serialization Service");

    private final @NotNull String name;

}
