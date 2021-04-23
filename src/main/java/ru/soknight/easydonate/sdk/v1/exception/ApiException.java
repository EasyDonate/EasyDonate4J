package ru.soknight.easydonate.sdk.v1.exception;

import okhttp3.ResponseBody;
import ru.soknight.easydonate.sdk.v1.response.ErrorResponse;

public class ApiException extends BadResponseException {
    private static final long serialVersionUID = 2591045437318877517L;
    
    private final ErrorResponse errorResponse;

    public ApiException(ErrorResponse errorResponse, ResponseBody rawResponse) {
        super(errorResponse.getMessage(), rawResponse);
        this.errorResponse = errorResponse;
    }
    
    /**
     * Get the error response data object.
     * @return The error response data.
     */
    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }
}
