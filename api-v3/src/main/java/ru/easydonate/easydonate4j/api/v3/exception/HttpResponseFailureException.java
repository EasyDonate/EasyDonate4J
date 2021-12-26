package ru.easydonate.easydonate4j.api.v3.exception;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.http.response.HttpResponse;

public class HttpResponseFailureException extends HttpResponseException {

    private static final String MESSAGE_FORMAT = "The API server has returned an unsuccessful HTTP response with code #%d (%s): %s";

    public HttpResponseFailureException(@NotNull HttpResponse response) {
        super(response, String.format(
                MESSAGE_FORMAT,
                response.getCode(),
                response.getMessage(),
                response.getContent()
        ));
    }

}
