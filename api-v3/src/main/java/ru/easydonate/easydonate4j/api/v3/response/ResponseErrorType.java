package ru.easydonate.easydonate4j.api.v3.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * The enum that represents all possible and actual response error types.
 * @see ErrorResponse#getErrorType()
 * @author soknight
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ResponseErrorType {

    /** Represents an unknown error. */
    UNKNOWN(0, "<unknown error>"),

    /** Represents the shop not found error. */
    SHOP_NOT_FOUND(1, "Shop not found"),

    /** Represents the requested element not found error. */
    ELEMENT_NOT_FOUND(2, "Requested element not found"),

    /** Represents the missing required request parameter(s) error. */
    MISSING_REQUIRED_PARAMETERS(3, "Missing required request parameter(s)"),

    /** Represents the request parameters format mismatch error. */
    WRONG_PARAMETER_VALUE_FORMAT(4, "Some of parameter values have a wrong format"),

    /** Represents the plugin is disabled error. */
    PLUGIN_IS_DISABLED(5, "This plugin is disabled"),

    /** Represents the internal plugin error. */
    PLUGIN_INTERNAL_ERROR(6, "An internal plugin error was occured");

    private final int errorCode;
    private final String description;

    /**
     * Get the enum constant by the known error code.
     * <br>
     * If a relevant enum constant with this error code will not be found then
     * this method will return {@link ResponseErrorType#UNKNOWN} constant as default.
     * @param errorCode the error code to find an enum constant.
     * @return The found response error enum constant or {@link ResponseErrorType#UNKNOWN} by default.
     */
    public static @NotNull ResponseErrorType getByNumber(int errorCode) {
        for(ResponseErrorType responseErrorCode : values())
            if(responseErrorCode.getErrorCode() == errorCode)
                return responseErrorCode;

        return UNKNOWN;
    }

}
