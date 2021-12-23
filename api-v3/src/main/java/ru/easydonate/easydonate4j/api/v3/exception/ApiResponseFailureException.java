package ru.easydonate.easydonate4j.api.v3.exception;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.response.ErrorResponse;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.http.response.HttpResponse;

@Getter
public class ApiResponseFailureException extends HttpResponseException {

    private final ErrorResponse errorResponse;

    public ApiResponseFailureException(@NotNull HttpResponse httpResponse, @NotNull ErrorResponse errorResponse) {
        super(httpResponse, String.format(
                "The API server has returned a failure response with code #%d (%s): %s",
                errorResponse.getErrorCode(), errorResponse.getErrorDescription(), errorResponse.getContent())
        );

        this.errorResponse = errorResponse;
    }

}
