package ru.easydonate.easydonate4j.api.v3.response;

import org.jetbrains.annotations.NotNull;

/**
 * The interface that presents an error response from the platform API.
 * @author soknight
 */
public interface ErrorResponse extends ApiResponse<String> {

    /**
     * Get the returned error code.
     * @return The returned error code.
     */
    int getErrorCode();

    /**
     * Try to find known error type for returned error code.
     * <br>
     * If there are no relevant enum constant will be found then the
     * {@link ResponseErrorType#UNKNOWN} constant will be returned here.
     * @return The relevant error type from the returned error code.
     * @see ResponseErrorType
     */
    default @NotNull ResponseErrorType getErrorType() {
        return ResponseErrorType.getByNumber(getErrorCode());
    }

    /**
     * Get the description of the found error type.
     * @return The description of the error.
     * @see #getErrorType()
     */
    default @NotNull String getErrorDescription() {
        return  getErrorType().getDescription();
    }

}
