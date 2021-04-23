package ru.soknight.easydonate.sdk.v1.exception;

import okhttp3.ResponseBody;

public class ErrorResponseException extends Exception {
    private static final long serialVersionUID = -7437956233362897312L;
    
    private final int statusCode;
    private final String message;
    private final ResponseBody errorResponse;

    public ErrorResponseException(int statusCode, String message, ResponseBody errorResponse) {
        super(message, null, false, false);
        
        this.statusCode = statusCode;
        this.message = message;
        this.errorResponse = errorResponse;
    }

    /**
     * Get the HTTP-response status code.
     * @return The HTTP status code.
     */
    public int getStatusCode() {
        return statusCode;
    }
    
    /**
     * Get the HTTP-response hint message which can shortly describe this error.
     * @return The HTTP response message.
     */
    @Override
    public String getMessage() {
        return message;
    }
    
    /**
     * Get the HTTP-response body.
     * @return The HTTP response body.
     */
    public ResponseBody getErrorResponse() {
        return errorResponse;
    }
}
