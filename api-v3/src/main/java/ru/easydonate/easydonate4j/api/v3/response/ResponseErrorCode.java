package ru.easydonate.easydonate4j.api.v3.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ResponseErrorCode {

    UNKNOWN(0, "<unknown error>"),
    SHOP_NOT_FOUND(1, "Shop not found"),
    ELEMENT_NOT_FOUND(2, "Requested element not found"),
    MISSING_REQUIRED_PARAMETERS(3, "Missing required request parameter(s)"),
    WRONG_PARAMETER_VALUE_FORMAT(4, "Some of parameter values have a wrong format"),
    PLUGIN_IS_DISABLED(5, "This plugin is disabled"),
    PLUGIN_INTERNAL_ERROR(6, "An internal plugin error was occured");

    private final int errorCode;
    private final String description;

    public static @NotNull ResponseErrorCode getByNumber(int errorCode) {
        for(ResponseErrorCode responseErrorCode : values())
            if(responseErrorCode.getErrorCode() == errorCode)
                return responseErrorCode;

        return UNKNOWN;
    }

}
