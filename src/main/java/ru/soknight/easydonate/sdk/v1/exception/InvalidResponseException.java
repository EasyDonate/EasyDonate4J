package ru.soknight.easydonate.sdk.v1.exception;

import okhttp3.ResponseBody;

public class InvalidResponseException extends BadResponseException {
    private static final long serialVersionUID = 5226865585428833303L;

    public InvalidResponseException(ResponseBody rawResponse) {
        super("the EasyDonate API server sent an invalid response", rawResponse);
    }
}
