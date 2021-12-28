package ru.easydonate.easydonate4j.api.v3.exception;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.http.response.EasyHttpResponse;

public class UnknownApiResponseException extends HttpResponseException {

    private static final String MESSAGE_FORMAT = "The API server has returned an unknown API response with status code #%d: %s";

    public UnknownApiResponseException(@NotNull EasyHttpResponse httpResponse, @NotNull Throwable cause) {
        super(httpResponse, String.format(MESSAGE_FORMAT, httpResponse.getCode(), httpResponse.getContent()), cause);
    }

}
