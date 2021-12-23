package ru.easydonate.easydonate4j.api.v3.exception;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.http.response.HttpResponse;

public class UnknownApiResponseException extends HttpResponseException {

    public UnknownApiResponseException(@NotNull HttpResponse httpResponse, @NotNull Throwable cause) {
        super(httpResponse, String.format(
                "The API server has returned an unknown API response with status code #%d: %s",
                httpResponse.getCode(), httpResponse.getContent()
        ), cause);
    }

}
