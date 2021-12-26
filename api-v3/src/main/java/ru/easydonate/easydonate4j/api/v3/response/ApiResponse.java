package ru.easydonate.easydonate4j.api.v3.response;

import org.jetbrains.annotations.Nullable;

/**
 * The generic interface that represents an HTTP response from the platform API.
 * @param <T> a type of the content.
 * @author soknight
 */
public interface ApiResponse<T> {

    /**
     * Check is this response is indicated as successful.
     * @return A boolean value: the check result.
     */
    boolean isSuccess();

    /**
     * Get the received content with specified content type.
     * @return The received content from this API response.
     */
    @Nullable T getContent();

}
