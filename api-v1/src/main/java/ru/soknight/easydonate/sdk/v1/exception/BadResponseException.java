package ru.soknight.easydonate.sdk.v1.exception;

import okhttp3.ResponseBody;

import java.io.IOException;

public abstract class BadResponseException extends IOException {
    private static final long serialVersionUID = 5226865585428833303L;
    
    private final ResponseBody rawResponse;

    public BadResponseException(String message, ResponseBody rawResponse) {
        super(message);
        this.rawResponse = rawResponse;
    }

    /**
     * Get raw response body.
     * @return The raw response body.
     */
    public ResponseBody getRawResponse() {
        return rawResponse;
    }
}
